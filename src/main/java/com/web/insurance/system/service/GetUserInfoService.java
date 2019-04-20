package com.web.insurance.system.service;

import com.auth0.jwt.JWT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class GetUserInfoService {

    @Resource
    private HttpServletRequest request;
    /**
     * 获取当前用户账号
     */
    public String getUserAccount(){
        String token = getToken();
        if (!token.isEmpty()) {
            return JWT.decode(token).getClaim("account").asString();
        }
        return null;
    }

    /**
     * 获取当前用户权限
     */
    public String getUserRole(){
        String token = getToken();
        return JWT.decode(token).getClaim("role").asString();
    }

    public String getToken(){
        Cookie[] cookie = request.getCookies();
        if(cookie == null){
            return null;
        }
        for (Cookie c : cookie) {
            if(c.getName().equals("token")){
                return c.getValue();
            }
        }
        return null;
    }
}
