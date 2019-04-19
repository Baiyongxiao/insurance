package com.web.insurance.system.service;

import com.auth0.jwt.JWT;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.system.enums.RoleEnum;
import com.web.insurance.system.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@Slf4j
@Service
public class UserService extends AbstractService {

    public Object getRole(String token){
        String role = JWT.decode(token).getClaim("role").asString();
        String name = JWT.decode(token).getClaim("name").asString();
        int id = JWT.decode(token).getClaim("id").asInt();
        HashMap<String ,String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("role", role);
        map.put("name", name);
        map.put("permissions", RoleEnum.toName(role));
        log.info("send vue user_role and message:{}",map);
        return map;
    }

    public PageInfo<User> findAllUser(User user) {
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> users = sqlSession.selectList("user.findAllUser");
        log.info("findAllUser message:{}",users);
        return new PageInfo<>(users);
    }

    public User findUserById(int id) {
        return sqlSession.selectOne("user.findUserById", id);
    }

    public User findByUserAccount(String account) {
        return sqlSession.selectOne("user.findByUserAccount",account);
    }

    @Transactional
    public String register(User user) {
        int i = 0;
        try{
            i = sqlSession.insert("user.register",user);
        }catch (Exception e){
            return "用户名已存在，请重新注册！";
        }
        if (i == 1) {
            return "注册成功，请返回登录！";
        }else{
            return "注册失败请重新注册";
        }
    }

    /**
     * 管理员更新用户信息
     * @param user
     * @return
     */
    @Transactional
    public int updateUser(User user) {
        user.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("user.updateUser", user);
    }

    /**
     * 用户自己更新信息
     * @param user
     * @return
     */
    @Transactional
    public int updateUserInfo(User user) {
        user.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("user.updateUserInfo", user);
    }
}
