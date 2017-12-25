package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CategoryMapper;
import vo.Category;

@Controller
public class CategoryAction {
	@Autowired
	CategoryMapper CategoryMapper;
	Logger logger = Logger.getLogger(CategoryAction.class);
	
	// insert
		@RequestMapping(value="json/Category/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Category p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				CategoryMapper.addCategory(p);
				map.put("mes", "success");
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/Category/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Category p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				CategoryMapper.modifyCategory(p);
				
				p.setName("");
				
				Category p2 = CategoryMapper.selectCategory(p);
				
				map.put("Category", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Category/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Category p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				CategoryMapper.deleteCategory(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Category/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Category p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Category> list = CategoryMapper.queryCategory(p);
				Integer count = CategoryMapper.countCategory(p);
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
		@RequestMapping(value="json/Category/showone",produces="application/json")
		public @ResponseBody Category showone(Category p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Category p2 = null;
			try {
				p2 = CategoryMapper.selectCategory(p);
//				map.put("success", true);
//				map.put("Category", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
