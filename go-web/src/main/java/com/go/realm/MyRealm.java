package com.go.realm;

 
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.go.service.UserService;
import com.go.smart.entity.ShiroUser;
import com.go.smart.entity.User;

/**
 * 
 * @ClassName: MyRealm
 * @Description: 用户登录验证，使用shiro 进行安全管理
 * @author 作者：b
 * @date 创建时间：2017年8月18日 下午8:25:48
 */
public class MyRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

	@Resource
	private UserService userServiceImpl;

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 
	 * @see 经测试:本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * @see 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
	 * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		// String currentUsername = (String) super.getAvailablePrincipal(principals);
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(shiroUser.getRoles());
		info.addStringPermissions(shiroUser.getUrlSet());
		return info;
	}

	/**
	 * 验证当前登录的Subject
	 * 
	 * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		LOGGER.info("shiro验证开始");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
		User user = userServiceImpl.getUserByName(userName);
		/* ============= */
		System.out.println(user.toString() + "doGetAuthenticationInfo");
		String password = new String((char[]) token.getCredentials());
		System.out.println(password);
		/* ============= */
		Map<String, Set<String>> map = userServiceImpl.getRolesAndUrls(user.getId());
		Set<String> urls = map.get("urls");
        Set<String> roles = map.get("roles");
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user.getName(), urls);
        shiroUser.setRoles(roles);
        // 认证缓存信息
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(shiroUser, user.getPassword(), getName());
		setSession("user", user);
        return authcInfo;
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject subject = SecurityUtils.getSubject();
		if (null != subject) {
			Session session = subject.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
}
