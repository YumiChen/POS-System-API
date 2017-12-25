package com.tcg.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import dao.DriverMapper;
import dao.OrderMapper;
//import vo.Driver;
import vo.Order;

@Controller
public class OrderAction {
	@Autowired
	OrderMapper orderMapper;
	Logger logger = Logger.getLogger(OrderAction.class);
	
	//  隨機分配司機
//	DriverMapper driverMapper;
	
	// insert
		@RequestMapping(value="json/Order/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Order p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			Date date = new Date();
			int thisYear =  date.getYear() + 1900;//thisYear = 2003
			int thisMonth = date.getMonth() + 1;//thisMonth = 5
			int thisDate = date.getDate();//thisDate = 30
			
			String month = thisMonth>=10?""+thisMonth:"0"+thisMonth;
			String dayy = thisDate>=10?""+thisDate:"0"+thisDate;
			
			String day = String.valueOf(thisYear+month+dayy);
			
			if(p.getIstransfer() == 2) p.setIstransfer(0);
			p.setId(day);
			String result = null;
			try {
				if(p.getIstransfer() == 0) {
					 orderMapper.addOrder0(p);
					 result = orderMapper.selectId();
				}else if(p.getIstransfer() == 1) {
					orderMapper.addOrder1(p);
					result = orderMapper.selectId();
				}
//				Order test = orderMapper.selectOrder(p);
//				if(test == null) {
//					throw new Exception();
//				}
				if(result == null) {
					throw new Exception();
				}
				
				map.put("success", result );
			}catch(Exception e) {
				map.put("success", "failed");
				e.printStackTrace();
			}
			
			return map;
		}
		
		//update
		@RequestMapping(value="json/Order/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Order p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				// 假如狀態改成已接受，隨機分配司機
//				if(p.getStatus() == 2) {
//					Driver temp = new Driver();
//					logger.info(temp);
//					try {
//						List<Driver> list = driverMapper.queryDriver(temp);
//						logger.info(list);
//						int sum = list.size();
//						String senderid = "";
//						while( senderid.equals("") || "AA0000".equals(senderid)) {
//							int index = (int)Math.random()*sum;
//							senderid = list.get(index).getId();
//						}
//						p.setSenderid(senderid);
//						p.setSenddate(" ");
//					}catch(Exception e) {
//						e.printStackTrace();
//					}
//					
//				}
				if(p.getStatus() == 2) {
					p.setSenderid("h0001");
				}
				// 假如狀態改為運送中，將送貨日期訂為三天後
				if(p.getStatus() == 3) {
					// get current date
					Date date = new Date();
					int thisYear =  date.getYear() + 1900;//thisYear = 2003
					int thisMonth = date.getMonth() + 1;//thisMonth = 5
					int thisDate = date.getDate();//thisDate = 30
					
					String month = thisMonth>=10?""+thisMonth:"0"+thisMonth;
					String dayy = thisDate>=10?""+thisDate:"0"+thisDate;
					
					String day = String.valueOf(thisYear+"/"+month+"/"+dayy);
					
					// set it to be three days later
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Calendar c = Calendar.getInstance();
					sdf.setTimeZone(c.getTimeZone());
					c.setTime(sdf.parse(day));
					c.add(Calendar.DATE, 3);  // number of days to add
					day = sdf.format(c.getTime());  // dt is now the new date
					
					p.setSenddate(day);
				}
				
				

				
				
				if(p.getIstransfer() == 0) {
					orderMapper.modifyOrder0(p);
				}else if(p.getIstransfer() == 1) {
					orderMapper.modifyOrder1(p);
				}
				p.setSenddate("");
				p.setSenderid("");
				p.setStatus(0);
				p.setSourceid(-1);
				p.setPid(0);
				p.setIstransfer(-1);
				p.setRequesterid("");
				p.setWishdate("");
				Order p2 = orderMapper.selectOrder(p);
				
				map.put("Order", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Order/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Order p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				orderMapper.deleteOrder(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Order/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Order p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Order> list = orderMapper.queryOrder(p);
				Integer count = orderMapper.countOrder(p);
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
		@RequestMapping(value="json/Order/showone",produces="application/json")
		public @ResponseBody Order showone(Order p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Order p2 = null;
			try {
				p2 = orderMapper.selectOrder(p);
//				map.put("success", true);
//				map.put("Order", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
		// validate or not
		@RequestMapping(value="json/Order/handlevalidation",produces="application/json")
		public @ResponseBody HashMap<String,Object> validateornot(Order p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				orderMapper.validateornot(p);
				
				p.setSenddate("");
				p.setSenderid("");
				p.setStatus(0);
				p.setSourceid(-1);
				p.setPid(-1);
				p.setIstransfer(-1);
				
				Order p2 = orderMapper.selectOrder(p);
				
				map.put("Order", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			return map;
	}
}
