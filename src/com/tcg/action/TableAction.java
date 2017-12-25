package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.TableMapper;

@Controller
public class TableAction {
	@Autowired
	TableMapper TableMapper;
	Logger logger = Logger.getLogger(TableAction.class);
	
		// this api returns columns of all tables
		@RequestMapping(value="json/Table/getinfo",produces="application/json")
		public @ResponseBody HashMap<String,Object> getinfo() {
			HashMap<String,Object> map = new HashMap<String,Object>();	
			try {
				List<HashMap<String,String>> list = TableMapper.selectTable();
				map.put("mes", "success");
				map.put("info",list);
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			return map;
		}
		
		@RequestMapping(value="json/Table/gettablenames",produces="application/json")
		public @ResponseBody HashMap<String,Object> getTableNames() {
			HashMap<String,Object> map = new HashMap<String,Object>();	
			try {
				List<String> list = TableMapper.selectTableNames();
				map.put("mes", "success");
				map.put("info",list);
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			return map;
		}
		
		@RequestMapping(value="json/Table/getTable",produces="application/json")
		public @ResponseBody HashMap<String,Object> getOneTable(@RequestParam(value = "name") String name) {
			HashMap<String,Object> map = new HashMap<String,Object>();	
			try {
				List<HashMap<String,String>> list = TableMapper.selectOneTable(name);
				map.put("mes", "success");
				map.put("tablename", name);
				map.put("info",list);
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			return map;
		}
		
		@RequestMapping(value="json/Table/getPK",produces="application/json")
		public @ResponseBody HashMap<String,Object> getPK(@RequestParam(value = "name") String name) {
			HashMap<String,Object> map = new HashMap<String,Object>();	
			try {
				List<String> list = TableMapper.getPK(name);
				map.put("mes", "success");
//				map.put("tablename", name);
				map.put("info",list);
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			return map;
		}
}
