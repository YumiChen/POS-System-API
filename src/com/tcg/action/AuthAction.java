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
public class AuthAction {
	@Autowired
	UserMapper userMapper;
	Logger logger = Logger.getLogger(TableAction.class);
	
	@RequestMapping(value="auth",method = RequestMethod.GET, produces="application/json")
	public @ResponseBody HashMap<String,Object> auth(ServletRequest req,
			@RequestParam(value = "id") String id
			,@RequestParam(value = "password") String password
			,ModelMap model) {
		HashMap<String,Object> map = new HashMap<String,Object>();	
		try {
			
			String token;
			User user = new User();
			user.setId(id);
			User result = userMapper.selectUser(user);
			
			if(result == null) {
				// no user exists
				throw new NoSuchUserException();
			}
			if(result.getPassword().equals(password) ) {
				// password is right
				// check if the user's authorized
				if(result.getAuthcode() != 1) {
					throw new NotAuthorizedException();
				}
				// generate token
				SecureRandom random = new SecureRandom();
				byte bytes[] = new byte[20];
				random.nextBytes(bytes);
				token = bytes.toString();

				 HttpServletRequest request = (HttpServletRequest) req;
				 HttpSession session = request.getSession(true);
				 session.setAttribute("token", token);
				 model.addAttribute("token",token);

				 System.out.println(session.getAttribute("token"));
				 System.out.println("session");
				 
			}else {
				// password is wrong
				throw new WrongPasswordException();
			}
			map.put("success", true);
			map.put("mes", token);
		}catch(NoSuchUserException e) {
			map.put("success", false);
			map.put("mes", 0);
		}catch(WrongPasswordException e) {
			map.put("success", false);
			map.put("mes", 1);
		}catch(NotAuthorizedException e) {
			map.put("success", false);
			map.put("mes", 2);
		}
		return map;
	}
}
