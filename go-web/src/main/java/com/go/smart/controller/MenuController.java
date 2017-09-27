package com.go.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title: MenuController.java
 * @Package com.go.smart.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年9月22日 下午7:22:55
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

	@RequestMapping(value = "/ceishi", method = RequestMethod.GET)
	public String ceishi(){
		return "ceishi";
	}
	
	@RequestMapping(value="/myInfo", method = RequestMethod.GET)
	public String myInfo(){
		return "mywork/myInfo";
	}
	
	@RequestMapping(value="/updateInfo", method = RequestMethod.GET)
	public String updateInfo(){
		return "mywork/updateInfo";
	}
	
	@RequestMapping(value = "/custmanager", method = RequestMethod.GET)
	public String custmanager(){
		return "customer/custmanager";
	}
	
}
