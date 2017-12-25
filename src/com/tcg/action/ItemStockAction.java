package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ItemStockMapper;
import vo.ItemStock;
import vo.ItemStockSearch;

@Controller
public class ItemStockAction {
	@Autowired
	ItemStockMapper ItemStockMapper;
	Logger logger = Logger.getLogger(ItemStockAction.class);

		// query
		@RequestMapping(value="json/ItemStock/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(ItemStock p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<ItemStock> list = ItemStockMapper.queryItemStock(p);
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
		@RequestMapping(value="json/ItemStockSearch/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> search(ItemStockSearch p) {
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<ItemStock> list = ItemStockMapper.searchItemStock(p);
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
		
		// showone
//		@RequestMapping(value="json/ItemStock/showone",produces="application/json")
//		public @ResponseBody ItemStock showone(ItemStock p) {
//			logger.info(p);
////			HashMap<String,Object> map =  new HashMap<String,Object>();
//			ItemStock p2 = null;
//			try {
//				p2 = ItemStockMapper.selectItemStock(p);
////				map.put("success", true);
////				map.put("ItemStock", p2);
//			}catch(Exception e) {
////				map.put("success", false);
//				e.printStackTrace();
//			}
//			return p2;
//	}
}
