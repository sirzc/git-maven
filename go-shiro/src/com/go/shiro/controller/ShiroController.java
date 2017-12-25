package com.go.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.go.shiro.bean.User;

/**
 * @Title: ShiroController.java
 * @Package com.go.shiro.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月27日 上午10:50:56
 * @version V1.0
 */
@Controller
@RequestMapping("shiro")
public class ShiroController {

	@RequestMapping(value = "/login")
	public String login(User user) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			token.setRememberMe(true);
			try {
				System.out.println(user.toString());
				System.out.println(token.hashCode());
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				System.out.println("There is no user with username of " + token.getPrincipal());
			} catch (IncorrectCredentialsException ice) {
				System.out.println("Password for account " + token.getPrincipal() + " was incorrect!");
			} catch (LockedAccountException lae) {
				System.out.println("The account for username " + token.getPrincipal() + " is locked.  "
						+ "Please contact your administrator to unlock it.");
			} catch (AuthenticationException ae) {
				// unexpected condition? error?
			}
		}
		return "redirect:/success.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "login";
	}
}
