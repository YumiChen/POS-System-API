package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ItemMapper;
import vo.Item;

@Controller
public class ItemAction {
	@Autowired
	ItemMapper ItemMapper;
	Logger logger = Logger.getLogger(ItemAction.class);
	
	// insert
		@RequestMapping(value="json/Item/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Item p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				ItemMapper.addItem(p);
				Item test = ItemMapper.selectItem(p);
				if(test == null) {
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
		@RequestMapping(value="json/Item/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Item p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				ItemMapper.modifyItem(p);
				
				p.setMenuf("");
				p.setName("");
				p.setPrice(-1);
				p.setCategory(-1);
				p.setSafenum(-1);
				p.setCost(-1);
				Item p2 = ItemMapper.selectItem(p);
				
				map.put("Item", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Item/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Item p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				ItemMapper.deleteItem(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Item/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Item p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Item> list = ItemMapper.queryItem(p);
				Integer count = ItemMapper.countItem(p);
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
		@RequestMapping(value="json/Item/showone",produces="application/json")
		public @ResponseBody Item showone(Item p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			Item p2 = null;
			try {
				p2 = ItemMapper.selectItem(p);
//				map.put("success", true);
//				map.put("Item", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
