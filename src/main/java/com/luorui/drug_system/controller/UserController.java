package com.luorui.drug_system.controller;

import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.User;
import com.luorui.drug_system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 罗锐
 * @date 2023/4/28
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 转向登录页面
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }
    /**
     * 判断用户是否登录成功
     */
    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toLogin(String username,String password){
        if (username == null || password == null){
            return ResultMapUtil.getHashMapLogin("用户名和密码不能为空","2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (UnknownAccountException exception){
            return ResultMapUtil.getHashMapLogin("用户名不存在","2");
        }catch (IncorrectCredentialsException exception){
            return ResultMapUtil.getHashMapLogin("用户密码错误","2");
        }
        return ResultMapUtil.getHashMapLogin("验证成功","1");
    }

    /**
     * 跳转到后台管理首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }
    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/logout";
    }

    @ResponseBody
    @RequestMapping(value = "/queryUser")
    public User queryUser(@RequestBody User user){
        return userService.queryUserByUsername(user);
    }
}
