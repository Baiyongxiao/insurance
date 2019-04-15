package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.Product;
import com.web.insurance.system.service.GetUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Resource
    private GetUserInfoService getUserInfoService;

    public PageInfo<Product> findAllProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = sqlSession.selectList("product.findAllProduct");
       return new PageInfo<>(products);
    }

    public int addProduct(Product product) {
        product.setCreatedUser(getUserInfoService.getUserAccount());
        return sqlSession.insert("product.addProduct", product);
    }
}
