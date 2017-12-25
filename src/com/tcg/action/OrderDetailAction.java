package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.OrderDetailMapper;
import vo.OrderDetail;
import vo.Stock;

@Controller
public class OrderDetailAction {
	@Autowired
	OrderDetailMapper OrderDetailMapper;
	Logger logger = Logger.getLogger(OrderDetailAction.class);
	
	// insert
		@RequestMapping(value="json/OrderDetail/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(OrderDetail p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				OrderDetailMapper.addOrderDetail(p);
				OrderDetail test = OrderDetailMapper.selectOrderDetail(p);
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
		@RequestMapping(value="json/OrderDetail/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(OrderDetail p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				OrderDetailMapper.modifyOrderDetail(p);
				
				
				OrderDetail p2 = OrderDetailMapper.selectOrderDetail(p);
				
				map.put("OrderDetail", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/OrderDetail/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(OrderDetail p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				OrderDetailMapper.deleteOrderDetail(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/OrderDetail/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(OrderDetail p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<OrderDetail> list = OrderDetailMapper.queryOrderDetail(p);
				Integer count = OrderDetailMapper.countOrderDetail(p);
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
		@RequestMapping(value="json/OrderDetail/showone",produces="application/json")
		public @ResponseBody OrderDetail showone(OrderDetail p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			OrderDetail p2 = null;
			try {
				p2 = OrderDetailMapper.selectOrderDetail(p);
//				map.put("success", true);
//				map.put("OrderDetail", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
