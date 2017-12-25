package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.PlaceTypeMapper;
import vo.PlaceType;

@Controller
public class PlaceTypeAction {
	@Autowired
	PlaceTypeMapper PlaceTypeMapper;
	Logger logger = Logger.getLogger(PlaceTypeAction.class);
	
	// insert
		@RequestMapping(value="json/PlaceType/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(PlaceType p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				PlaceTypeMapper.addPlaceType(p);
				map.put("mes", "success");
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/PlaceType/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(PlaceType p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				PlaceTypeMapper.modifyPlaceType(p);
				
				p.setName("");
				
				PlaceType p2 = PlaceTypeMapper.selectPlaceType(p);
				
				map.put("PlaceType", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/PlaceType/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(PlaceType p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				PlaceTypeMapper.deletePlaceType(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/PlaceType/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(PlaceType p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<PlaceType> list = PlaceTypeMapper.queryPlaceType(p);
				Integer count = PlaceTypeMapper.countPlaceType(p);
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
		@RequestMapping(value="json/PlaceType/showone",produces="application/json")
		public @ResponseBody PlaceType showone(PlaceType p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			PlaceType p2 = null;
			try {
				p2 = PlaceTypeMapper.selectPlaceType(p);
//				map.put("success", true);
//				map.put("PlaceType", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
