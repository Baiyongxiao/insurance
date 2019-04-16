package com.web.insurance.system.controller;

import com.web.insurance.annotation.CheckToken;
import com.web.insurance.annotation.LoginToken;
import com.web.insurance.system.entity.User;
import com.web.insurance.system.service.UserService;
import com.web.insurance.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * 用户控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/findAllUser")
    public Object findAllUser(@RequestBody User user){
        log.info("from vue received findAllUser message:{}",user);
        return userService.findAllUser(user);
    }

    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user){
        log.info("from vue received updatedUser message:{}",user);
        return userService.updateUser(user);
    }

    @GetMapping("/findByUserAccount")
    public User findUserByAccount(@RequestParam String account){
        log.info("from vue received findOneUser message:{}",account);
        return userService.findByUserAccount(account);
    }

    @PostMapping("/login")
    @LoginToken
    public Object login(@RequestBody @Valid User user){
        HashMap<String, Object> map = new HashMap<>();
        User userForBase = userService.findByUserAccount(user.getAccount());
        if (userForBase == null) {
            map.put("message", "登录失败,用户不存在");
            log.error("登录失败,用户不存在");
            map.put("status", false);
            return map;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                map.put("message", "登录失败,密码错误");
                log.error("登录失败,密码错误");
                map.put("status", false);
                return map;
            } else {
                String token = JwtUtil.createJWT(6000000, userForBase);
                map.put("token", token);
                map.put("user", userForBase);
                map.put("status", true);
                return map;
            }
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        log.info("from vue received register message:{}",user);
        return userService.register(user);
    }

    @CheckToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

    @GetMapping("/getRole")
    public Object getRole(String token){
        return userService.getRole(token);
    }
}
