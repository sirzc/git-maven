package com.go.action;

import com.go.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Title: UserLoginAction.java
 * @Package com.go.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年9月30日 下午10:04:39
 * @version V1.0
 */
public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		ActionContext actionContext = ActionContext.getContext();
		if ("zhou".equals(user.getUsername()) && "123".equals(user.getPassword())) {
				actionContext.getSession().put("username", user.getUsername());
		}else {
			actionContext.getSession().put("error", "用户名或者密码错误");
			result = ERROR;
		}
		return result;
	}

}
