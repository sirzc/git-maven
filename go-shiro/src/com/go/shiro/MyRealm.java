package com.go.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

/**   
 * @Title: MyRealm.java
 * @Package com.go.shiro
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月25日 下午8:23:12
 * @version V1.0   
 */
public class MyRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken paramAuthenticationToken)
			throws AuthenticationException {
		//1.把 AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken token = (UsernamePasswordToken) paramAuthenticationToken;
		//2.从UsernamePasswordToken 中获取 用户
		String username = token.getUsername();
		//3.获取数据库中的用户名
		
		//4.如果用户不存在则抛出异常
		if("unKonw".equals(username)) {
			throw new UnknownAccountException("未知用户");
		}
		//5.根据实际情况，决定抛出异常的类型
		if("monster".equals(username)) {
			throw new LockedAccountException("用户锁定");
		}
		Object principal = username;
		Object credentials = "123456";
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}
 
}
