package com.moke.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.core.advice.Result;
import com.moke.sys.model.User;

@RestController
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Result login(User user){
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());  
        //记录该令牌  
        token.setRememberMe(false);  
        //subject权限对象  
        Subject subject = SecurityUtils.getSubject();  
        try {  
            subject.login(token);  
        } catch (UnknownAccountException ex) {//用户名没有找到  
            ex.printStackTrace();  
        } catch (IncorrectCredentialsException ex) {//用户名密码不匹配  
            ex.printStackTrace();  
        }catch (AuthenticationException e) {//其他的登录错误  
            e.printStackTrace();  
        }  
          
        //验证是否成功登录的方法  
        if (subject.isAuthenticated()) {  
            return Result.sucess(subject);
        }  
        return Result.failure(subject);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public void logout() {
		Subject subject = SecurityUtils.getSubject();  
        subject.logout();
	}
}
