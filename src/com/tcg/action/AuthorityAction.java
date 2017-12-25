package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AuthorityMapper;
import vo.Authority;

@Controller
public class AuthorityAction {
	@Autowired
	AuthorityMapper authorityMapper;
	Logger logger = Logger.getLogger(AuthorityAction.class);
	
	// insert
		@RequestMapping(value="json/Authority/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Authority p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				authorityMapper.addAuthority(p);
				map.put("mes", "success");
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/Authority/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Authority p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				authorityMapper.modifyAuthority(p);
				
				p.setId(-1);
				p.setName("");
				
				Authority p2 = authorityMapper.selectAuthority(p);
				
				map.put("Authority", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Authority/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Authority p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				authorityMapper.deleteAuthority(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Authority/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Authority p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Authority> list = authorityMapper.queryAuthority(p);
				Integer count = authorityMapper.countAuthority(p);
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
		@RequestMapping(value="json/Authority/showone",produces="application/json")
		public @ResponseBody Authority showone(Authority p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Authority p2 = null;
			try {
				p2 = authorityMapper.selectAuthority(p);
//				map.put("success", true);
//				map.put("Authority", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
