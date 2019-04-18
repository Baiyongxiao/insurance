package com.web.insurance;

import com.web.insurance.system.service.GetUserInfoService;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

public class AbstractService {
    @Resource
    protected SqlSessionTemplate sqlSession;

    @Resource
    protected GetUserInfoService getUserInfoService;
}
