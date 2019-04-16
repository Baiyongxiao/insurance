package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.Product;
import com.web.insurance.system.service.GetUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Resource
    private GetUserInfoService getUserInfoService;

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

    public int updatedStatus(Product product) {
        product.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("product.updatedStatus",product);
    }
    public int updatedInfo(Product product) {
        product.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("product.updatedInfo",product);
    }
}
