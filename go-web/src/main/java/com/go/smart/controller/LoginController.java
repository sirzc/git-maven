package com.go.smart.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.go.service.LoginService;
import com.go.smart.entity.Resources;
import com.go.smart.entity.ShiroUser;
import com.go.smart.entity.User;
import com.go.tool.BaseController;
import com.go.tool.BeanUntil;

/**
 * @Title: LoginController.java
 * @Package com.go.smart.controller
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午9:44:41
 */
@Controller
@RequestMapping(value="/index")
public class LoginController extends BaseController{

	@javax.annotation.Resource
	private LoginService loginServiceImpl;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为 UsernamePasswordToken 对象
			System.out.println(user.toString());
			user.setPassword(BeanUntil.md5(user.getPassword(), "pms"));
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			// rememberme
			token.setRememberMe(true);
			try {
				System.out.println("1. " + token.hashCode());
				// 执行登录.
				currentUser.login(token);
				return "redirect:/jsp/index.jsp";
			}
			// ... catch more exceptions here (maybe custom ones specific to your
			// application?
			// 所有认证时异常的父类.
			catch (AuthenticationException ae) {
				// unexpected condition? error?
				System.out.println("登录失败: " + ae.getMessage());
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public List<Resources> menu() {
		ShiroUser shiroUser = getShiroUser();
		return loginServiceImpl.selectTree(shiroUser);
	}
	
	/** 
     * 用户登出 
     */  
    @RequestMapping("/logout")  
    public String logout(){
         SecurityUtils.getSubject().logout(); 
//         session.removeAttribute("user");
//         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";  
         return "redirect:/";
    }  
}
