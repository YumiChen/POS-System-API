package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.OrderStatusMapper;
import vo.OrderStatus;

@Controller
public class OrderStatusAction {
	@Autowired
	OrderStatusMapper OrderStatusMapper;
	Logger logger = Logger.getLogger(OrderStatusAction.class);
	
	// insert
		@RequestMapping(value="json/OrderStatus/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(OrderStatus p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				OrderStatusMapper.addOrderStatus(p);
				map.put("mes", "success");
			}catch(Exception e) {
				map.put("mes", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/OrderStatus/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(OrderStatus p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				OrderStatusMapper.modifyOrderStatus(p);
				
				p.setName("");
				
				OrderStatus p2 = OrderStatusMapper.selectOrderStatus(p);
				
				map.put("OrderStatus", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/OrderStatus/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(OrderStatus p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				OrderStatusMapper.deleteOrderStatus(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/OrderStatus/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(OrderStatus p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<OrderStatus> list = OrderStatusMapper.queryOrderStatus(p);
				Integer count = OrderStatusMapper.countOrderStatus(p);
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
		@RequestMapping(value="json/OrderStatus/showone",produces="application/json")
		public @ResponseBody OrderStatus showone(OrderStatus p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			OrderStatus p2 = null;
			try {
				p2 = OrderStatusMapper.selectOrderStatus(p);
//				map.put("success", true);
//				map.put("OrderStatus", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
