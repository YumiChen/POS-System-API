package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.SaleMapper;
import vo.Sale;

@Controller
public class SaleAction {
	@Autowired
	SaleMapper SaleMapper;
	Logger logger = Logger.getLogger(SaleAction.class);
	
	// insert
		@RequestMapping(value="json/Sale/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Sale p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				SaleMapper.addSale(p);
				Sale test = SaleMapper.selectSale(p);
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
		@RequestMapping(value="json/Sale/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Sale p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				SaleMapper.modifySale(p);
				p.setNum(-1);
				Sale p2 = SaleMapper.selectSale(p);
				
				map.put("Sale", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Sale/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Sale p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				SaleMapper.deleteSale(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Sale/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Sale p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Sale> list = SaleMapper.querySale(p);
				Integer count = SaleMapper.countSale(p);
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
		@RequestMapping(value="json/Sale/showone",produces="application/json")
		public @ResponseBody Sale showone(Sale p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Sale p2 = null;
			try {
				p2 = SaleMapper.selectSale(p);
//				map.put("success", true);
//				map.put("Sale", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
