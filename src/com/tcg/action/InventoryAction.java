package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.InventoryMapper;
import vo.Inventory;

@Controller
public class InventoryAction {
	@Autowired
	InventoryMapper InventoryMapper;
	Logger logger = Logger.getLogger(InventoryAction.class);
	
	// insert
		@RequestMapping(value="json/Inventory/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Inventory p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				InventoryMapper.addInventory(p);
				Inventory test = InventoryMapper.selectInventory(p);
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
		@RequestMapping(value="json/Inventory/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Inventory p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				InventoryMapper.modifyInventory(p);
				
				
				Inventory p2 = InventoryMapper.selectInventory(p);
				
				map.put("Inventory", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Inventory/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Inventory p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				InventoryMapper.deleteInventory(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Inventory/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Inventory p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Inventory> list = InventoryMapper.queryInventory(p);
				Integer count = InventoryMapper.countInventory(p);
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
		@RequestMapping(value="json/Inventory/showone",produces="application/json")
		public @ResponseBody Inventory showone(Inventory p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Inventory p2 = null;
			try {
				p2 = InventoryMapper.selectInventory(p);
//				map.put("success", true);
//				map.put("Inventory", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
