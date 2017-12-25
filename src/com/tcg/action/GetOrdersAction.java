package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.GetOrdersMapper;
import vo.OrderDetailResult;
import vo.OrderResult;

@Controller
public class GetOrdersAction {
	
		@Autowired
		GetOrdersMapper getOrdersMapper;
		Logger logger = Logger.getLogger(GetOrdersAction.class);
		
			// query
			@RequestMapping(value="json/GetOrders/query",produces="application/json")
			public @ResponseBody HashMap<String,Object> qr(OrderResult p) {
				logger.info(p);
				HashMap<String,Object> map =  new HashMap<String,Object>();
				try {
					List<OrderResult> list;
					Integer count ;
					System.out.println("istransfer!!! "+p.getIstransfer());
					if(p.getIstransfer() == 0) {
						list = getOrdersMapper.getOrdersn(p);
//						count = getOrdersMapper.countOrder(p);
					}else if(p.getIstransfer() == 1) {
						list = getOrdersMapper.getOrderst(p);
//						count = getOrdersMapper.countOrder(p);
					}else {
						Exception exception = new Exception();
						throw exception;
					}
					map.put("success", true);
					map.put("list", list);
					map.put("count", list.size());
				}catch(Exception e) {
					map.put("success", false);
					e.printStackTrace();
				}
				return map;
			}
			
			// query
						@RequestMapping(value="json/GetOrderDetails/query",produces="application/json")
						public @ResponseBody HashMap<String,Object> qr(OrderDetailResult p) {
							logger.info(p);
							HashMap<String,Object> map =  new HashMap<String,Object>();
							try {
								
								List<OrderDetailResult> list = getOrdersMapper.getOrderDetail(p);
//								Integer count = getOrdersMapper.countOrderDetail(p);
								
								map.put("success", true);
								map.put("list", list);
								map.put("count", list.size());
							}catch(Exception e) {
								map.put("success", false);
								e.printStackTrace();
							}
							return map;
						}
		
	}
