package com.web.insurance;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

public class AbstractService {
    @Resource
    protected SqlSessionTemplate sqlSession;
}
