package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserMapper;
import vo.User;

@Controller
public class UserAction {
	@Autowired
	UserMapper UserMapper;
	Logger logger = Logger.getLogger(UserAction.class);
	
	// insert
		@RequestMapping(value="json/User/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(User p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				UserMapper.addUser(p);
				User test = UserMapper.selectUser(p);
				if(test==null) {
					throw new Exception();
				}
				map.put("mes", "success");
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/User/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(User p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				UserMapper.modifyUser(p);
				
//				p.setDid("");
				p.setEmail("");
				p.setAuthcode(-1);
				p.setName("");
				p.setPassword("");
				p.setPhone("");
				p.setPid(-1);
								
				User p2 = UserMapper.selectUser(p);
				
				map.put("User", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/User/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(User p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				UserMapper.deleteUser(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/User/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(User p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<User> list = UserMapper.queryUser(p);
				Integer count = UserMapper.countUser(p);
				map.put("success", true);
				map.put("list", list);
				map.put("count", count);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			return map;
		}
		
		// showone
		@RequestMapping(value="json/User/showone",produces="application/json")
		public @ResponseBody User showone(User p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			User p2 =  null;
			try {
				p2 = UserMapper.selectUser(p);
				//map.put("success", true);
//				map.put("User", p2);
			}catch(Exception e) {
//				map.put("User", "Fail");
				//map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
