package com.web.insurance.controller;

import com.web.insurance.entity.Product;
import com.web.insurance.service.ProductService;
import com.web.insurance.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 对保险产品进行增删改查
 */

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private SearchService searchService;

    @PostMapping("/findAllProduct")
    public Object findAllProduct(@RequestBody Product product){
        log.info("from vue received findAllProduct message:{}",product);
        String name = product.getName();
        if (name != null) {
            if(!searchService.judgeIfExist(name)){
                searchService.insertInfo(name);
            }
        }
        return productService.findAllProduct(product);
    }

    @PostMapping("/addProduct")
    public int addProduct(@RequestBody Product product){
        log.info("from vue received addProduct message:{}",product);
        return productService.addProduct(product);
    }

    /**
     * 修改保险状态
     * @return
     */
    @PostMapping("/updatedStatus")
    public int updatedStatus(@RequestBody Product product){
        log.info("from vue received updatedStatus message:{}",product);
        return productService.updatedStatus(product);
    }
    @PostMapping("/updatedInfo")
    public int updatedInfo(@RequestBody Product product){
        log.info("from vue received updatedInfo message:{}",product);
        return productService.updatedInfo(product);
    }

    //TODO 智能推荐
    @PostMapping("/recommendSearch")
    public Object recommendSearch(@RequestBody Product product){
        return productService.recommendSearch(product);
    }
}
