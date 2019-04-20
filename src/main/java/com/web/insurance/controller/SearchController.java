package com.web.insurance.controller;

import com.web.insurance.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @GetMapping("/findAllSearch")
    public List<Object> findAllSearch(){
        return searchService.findAllSearch();
    }
}
