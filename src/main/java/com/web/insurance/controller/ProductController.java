package com.web.insurance.controller;

import com.web.insurance.entity.Product;
import com.web.insurance.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 对保险产品进行增删改查
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/findAllProduct")
    public Object findAllProduct(@RequestParam int pageNum,
                                 @RequestParam int pageSize){

        return productService.findAllProduct(pageNum,pageSize);
    }

    @PostMapping("/addProduct")
    public int addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    /**
     * 所有的修改操作
     * @return
     */
    @GetMapping("/edit")
    public int editStatus(){
        return 0;
    }
}
