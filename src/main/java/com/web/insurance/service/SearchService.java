package com.web.insurance.service;

import com.web.insurance.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SearchService extends AbstractService {

    /**
     * 查询用户所有的搜索记录
     * @return
     */
    public List<Object> findAllSearch() {
        return sqlSession.selectList("search.findAllSearch", getUserInfoService.getUserAccount());
    }

    /**
     * 判断是否存在该搜索记录
     * @param name
     */
    public boolean judgeIfExist(String name) {
        int i = sqlSession.selectOne("search.judgeIfExist", name);
        if (i == 1) {
            return true;
        }
        return false;
    }

    /**
     * 新增一条搜索记录
     * @param name
     */
    @Transactional
    public void insertInfo(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("value", name);
        map.put("account", getUserInfoService.getUserAccount());
        sqlSession.insert("search.insertInfo",map);
    }
}
