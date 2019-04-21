package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.History;
import com.web.insurance.entity.Product;
import com.web.insurance.system.entity.User;
import com.web.insurance.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class HistoryService extends AbstractService {

    @Resource
    private ProductService productService;

    @Resource
    private ProgramService programService;

    @Resource
    private UserService userService;

    /**
     * 根据用户账号查询用户所有历史记录
     * @param history
     * @return
     */
    public PageInfo<Product> findAllHistory(History history) {
        PageHelper.startPage(history.getPageNum(), history.getPageSize());
        history.setAccount(getUserInfoService.getUserAccount());
        List<Integer> productIds = sqlSession.selectList("history.findAllHistory", history);
        List<Product> result = productService.findHistory(productIds);
        return new PageInfo<>(result);
    }

    /**
     * 用户投票存入历史记录方法
     * @param history
     * @return
     */
    @Transactional
    public int voted(History history) {
        programService.updateCount(history.getProgramId());
        history.setAccount(getUserInfoService.getUserAccount());
        return sqlSession.insert("history.voted", history);
    }

    /**
     * 判断是否存在该条记录
     * @param map
     * @return
     */
    public boolean judgeExist(Map map){
        int i = sqlSession.selectOne("history.judgeExist", map);
        if(i == 1){
            return true;
        }
        return false;
    }

    /**
     * 根据账号和产品id获取方案id
     * @param map
     * @return
     */
    public int getProgramId(Map map){
        return sqlSession.selectOne("history.getProgramId", map);
    }

    /**
     * 根据id修改历史记录显示状态为0：不显示
     * @param id
     * @return
     */
    public int deleteHistory(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("productId", id);
        map.put("account", getUserInfoService.getUserAccount());
        return sqlSession.update("history.deleteHistory",map);
    }

    /**
     * 管理员查看投票该方案的用户
     *
     * @param history
     * @return
     */
    public PageInfo<User> selectVotedUser(History history) {
        PageHelper.startPage(history.getPageNum(), history.getPageSize());
        List<String> accounts = sqlSession.selectList("history.selectVotedUser",history);
        List<User> result = userService.selectVotedUser(accounts);
        return new PageInfo<>(result);
    }
}
