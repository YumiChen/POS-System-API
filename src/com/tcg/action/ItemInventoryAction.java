package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ItemInventoryMapper;
import vo.ItemInventory;

@Controller
public class ItemInventoryAction {
	@Autowired
	ItemInventoryMapper ItemInventoryMapper;
	Logger logger = Logger.getLogger(ItemInventoryAction.class);

		// query
		@RequestMapping(value="json/ItemInventory/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qq(ItemInventory p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<ItemInventory> list = ItemInventoryMapper.queryItemInventory(p);
				Integer count = list.size();
				map.put("success", true);
				map.put("list", list);
				map.put("count", count);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			return map;
		}
		
		// query
		@RequestMapping(value="json/InventoryLoss/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qt(ItemInventory p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<ItemInventory> list = ItemInventoryMapper.queryInventoryLoss(p);
				Integer count = list.size();
				map.put("success", true);
				map.put("list", list);
				map.put("count", count);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			return map;
		}
		
		// query
		@RequestMapping(value="json/ItemInventoryAll/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(ItemInventory p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<ItemInventory> list = ItemInventoryMapper.queryInventoryAll(p);
				Integer count = list.size();
				map.put("success", true);
				map.put("list", list);
				map.put("count", count);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			return map;
		}

}
