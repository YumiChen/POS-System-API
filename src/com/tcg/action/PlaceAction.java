package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.PlaceMapper;
import vo.Place;

@Controller
public class PlaceAction {
	@Autowired
	PlaceMapper PlaceMapper;
	Logger logger = Logger.getLogger(PlaceAction.class);
	
	// insert
		@RequestMapping(value="json/Place/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Place p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				PlaceMapper.addPlace(p);
//				Place test = PlaceMapper.selectPlace(p);
//				if(test == null) {
//					throw new Exception();
//				}
				map.put("mes", "success");
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/Place/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Place p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				PlaceMapper.modifyPlace(p);
				
				p.setAddr("");
				p.setName("");
				p.setOwner("");
				p.setPhone("");
				p.setType(-1);
				
				Place p2 = PlaceMapper.selectPlace(p);
				
				map.put("Place", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Place/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Place p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				PlaceMapper.deletePlace(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Place/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Place p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Place> list = PlaceMapper.queryPlace(p);
				Integer count = PlaceMapper.countPlace(p);
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
		@RequestMapping(value="json/Place/showone",produces="application/json")
		public @ResponseBody Place showone(Place p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Place p2 = null;
			try {
				p2 = PlaceMapper.selectPlace(p);
//				map.put("success", true);
//				map.put("Place", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
