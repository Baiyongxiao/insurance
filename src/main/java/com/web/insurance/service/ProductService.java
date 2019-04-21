package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService extends AbstractService {


    public PageInfo<Product> findAllProduct(Product product) {
        PageHelper.startPage(product.getPageNum(), product.getPageSize());
        List<Product> products = sqlSession.selectList("product.findAllProduct",product);
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
        return sqlSession.update("product.updatedStatus",product);
    }
    @Transactional
    public int updatedInfo(Product product) {
        product.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("product.updatedInfo",product);
    }

    /**
     * 根据历史记录查询的产品id来批量进行查询
     */
    public List<Product> findHistory(List<Integer> list){
        return sqlSession.selectList("product.findHistory", list);
    }
}
