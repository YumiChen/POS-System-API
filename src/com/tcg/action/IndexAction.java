// content server

package com.tcg.action;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.TableMapper;
import dao.UserMapper;
import exceptions.NoSuchUserException;
import exceptions.NotAuthorizedException;
import exceptions.WrongPasswordException;
import vo.User;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("token")
public class IndexAction {
	@Autowired
	UserMapper userMapper;
	Logger logger = Logger.getLogger(TableAction.class);
	
	@RequestMapping("cms")
	public String cms() {
		return "cms";
	}
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping("unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}
//	@RequestMapping("apidoc")
//	public String apidoc() {
////		return "cms";
//		return "static/index";
//	}
}
