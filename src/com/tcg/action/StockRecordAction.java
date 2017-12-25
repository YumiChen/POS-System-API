package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.StockRecordMapper;
import vo.StockRecord;

@Controller
public class StockRecordAction {
	@Autowired
	StockRecordMapper StockRecordMapper;
	Logger logger = Logger.getLogger(StockRecordAction.class);
	
	// insert
		@RequestMapping(value="json/StockRecord/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(StockRecord p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				StockRecordMapper.addStockRecord(p);
				StockRecord test = StockRecordMapper.selectStockRecord(p);
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
		@RequestMapping(value="json/StockRecord/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(StockRecord p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				StockRecordMapper.modifyStockRecord(p);
				
				p.setDay(-1);
				p.setMonth(-1);
				p.setNum(-1);
				p.setYear(-1);
				p.setTime("");
				
				StockRecord p2 = StockRecordMapper.selectStockRecord(p);
				
				map.put("StockRecord", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/StockRecord/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(StockRecord p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				StockRecordMapper.deleteStockRecord(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/StockRecord/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(StockRecord p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<StockRecord> list = StockRecordMapper.queryStockRecord(p);
				Integer count = StockRecordMapper.countStockRecord(p);
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
		@RequestMapping(value="json/StockRecord/showone",produces="application/json")
		public @ResponseBody StockRecord showone(StockRecord p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			StockRecord p2 = null;
			try {
				p2 = StockRecordMapper.selectStockRecord(p);
//				map.put("success", true);
//				map.put("StockRecord", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
