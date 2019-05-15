package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.Product;
import com.web.insurance.entity.Weight;
import com.web.insurance.enums.IEnum;
import com.web.insurance.enums.InsuranceEnglishEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Resource
    private WeightService weightService;
    @Resource
    private HistoryService historyService;


    public PageInfo<Product> findAllProduct(Product product) {
        PageHelper.startPage(product.getPageNum(), product.getPageSize());
        List<Product> products = sqlSession.selectList("product.findAllProduct", product);
        return new PageInfo<>(products);
    }

    @Transactional
    public int addProduct(Product product) {
        product.setCreatedUser(getUserInfoService.getUserAccount());
        return sqlSession.insert("product.addProduct", product);
    }

    @Transactional
    public int updatedStatus(Product product) {
        product.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("product.updatedStatus", product);
    }

    @Transactional
    public int updatedInfo(Product product) {
        product.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("product.updatedInfo", product);
    }

    /**
     * 根据历史记录查询的产品id来批量进行查询
     */
    public List<Product> findHistory(List<Integer> list) {
        return sqlSession.selectList("product.findHistory", list);
    }

    /**
     * 根据用户权重进行智能推荐
     *
     * @param product
     * @return
     */
    public PageInfo<Product> recommendSearch(Product product) {
        PageHelper.startPage(product.getPageNum(), product.getPageSize());
        Weight weight = weightService.findByAccount();
        int sumWeight = weight.getSumWeight();
        if (sumWeight < 10) {
            //TODO 按默认方式推荐然后返回
            List<Product> products = sqlSession.selectList("product.orderByCount");
            return new PageInfo<>(products);
        }
        /**
         * 查询历史记录该用户投过产品的所有id,并过滤掉投过票的
         */
        List<Integer> productIds = historyService.findByAccount();
        List<Product> productList = sqlSession.selectList("product.filterVoted", productIds);
        List<Product> productsTwo = filterProductByWeight(productList,weight);
        return new PageInfo<>(productsTwo);
    }

    /**
     * 增加产品投票总数
     *
     * @param id
     */
    public void addProductCount(int id) {
        sqlSession.update("product.addProductCount", id);
    }

    public List<Product> filterProductByWeight(List<Product> products, Weight weight) {
        List<Product> productList = new ArrayList<>();
        String[] insuranceEnum = {"car", "travel", "accident", "healthy", "children", "life", "illness", "property", "other"};
        int[] weightNum = weight.getWeightNum();
        for (int i = 0; i < insuranceEnum.length; i++) {
            productList = addProducts(products, productList, IEnum.nameToId(InsuranceEnglishEnum.class, insuranceEnum[i]),weightNum[i]);
        }

        return products;
    }

    public List<Product> addProducts(List<Product> products, List<Product> productList, int classification, int num) {
        for (Product product : products) {
            int count = 0;
            if (product.getClassification() == classification) {
                productList.add(product);
                count++;
            }
            if (count >= num) {
                break;
            }
        }
        return productList;
    }
}
