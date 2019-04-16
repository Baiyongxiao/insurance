package com.web.insurance.controller;

import com.web.insurance.enums.IEnum;
import com.web.insurance.enums.InsuranceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/enum")
public class EnumController {

    @GetMapping("getClassify")
    public List<Map<String, String>> getClassify(){
        return IEnum.toSelect(InsuranceEnum.class);
    }
}
