package com.web.insurance.service;

import com.web.insurance.AbstractService;
import com.web.insurance.entity.History;
import com.web.insurance.entity.Weight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class WeightService extends AbstractService {

    /**
     * 新增用户权重，默认初始值为0
     * @param account
     * @return
     */
    //TODO
    public int insertWeight(String account){
        return sqlSession.insert("weight.insertWeight", account);
    }

    /**
     * 根据classification增加一个权重
     */
    public void updatedAddWeight(Map map){
        sqlSession.update("weight.updatedAddWeight", map);
    }
    /**
     * 根据classification减少一个权重
     */
    public void updatedDownWeight(Map map){
        sqlSession.update("weight.updatedDownWeight", map);
    }

    /**
     * 根据用户账号查询用户权重
     */
    public Weight findByAccount(){
        return sqlSession.selectOne("weight.findByAccount", getUserInfoService.getUserAccount());
    }
}
