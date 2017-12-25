package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.SaleRecordMapper;
import vo.SaleRecord;

@Controller
public class SaleRecordAction {
	@Autowired
	SaleRecordMapper SaleRecordMapper;
	Logger logger = Logger.getLogger(SaleRecordAction.class);
	
	// insert
		@RequestMapping(value="json/SaleRecord/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(SaleRecord p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				SaleRecordMapper.addSaleRecord(p);
				SaleRecord test = SaleRecordMapper.selectSaleRecord(p);
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
		@RequestMapping(value="json/SaleRecord/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(SaleRecord p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				SaleRecordMapper.modifySaleRecord(p);
				
				p.setDay(-1);
				p.setMonth(-1);
				p.setNum(-1);
				p.setYear(-1);
				
				SaleRecord p2 = SaleRecordMapper.selectSaleRecord(p);
				
				map.put("SaleRecord", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/SaleRecord/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(SaleRecord p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				SaleRecordMapper.deleteSaleRecord(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/SaleRecord/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(SaleRecord p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<SaleRecord> list = SaleRecordMapper.querySaleRecord(p);
				Integer count = SaleRecordMapper.countSaleRecord(p);
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
		@RequestMapping(value="json/SaleRecord/showone",produces="application/json")
		public @ResponseBody SaleRecord showone(SaleRecord p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			SaleRecord p2 = null;
			try {
				p2 = SaleRecordMapper.selectSaleRecord(p);
//				map.put("success", true);
//				map.put("SaleRecord", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
