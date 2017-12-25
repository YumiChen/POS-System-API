package com.tcg.action;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VehicleMapper;
import vo.Inventory;
import vo.Vehicle;

@Controller
public class VehicleAction {
	@Autowired
	VehicleMapper VehicleMapper;
	Logger logger = Logger.getLogger(VehicleAction.class);
	
	// insert
		@RequestMapping(value="json/Vehicle/add",produces="application/json")
		public @ResponseBody HashMap<String,String> add(Vehicle p) {
			System.out.println(p);
			HashMap<String,String> map = new HashMap<String,String>();
			
			try {
				VehicleMapper.addVehicle(p);
				Vehicle test = VehicleMapper.selectVehicle(p);
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
		@RequestMapping(value="json/Vehicle/update",produces="application/json")
		public @ResponseBody HashMap<String,Object> update(Vehicle p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				VehicleMapper.modifyVehicle(p);
				
//				p.setColor("");
				p.setDriver("");
				p.setMenuf("");
				p.setType("");
				
				Vehicle p2 = VehicleMapper.selectVehicle(p);
				
				map.put("Vehicle", p2);
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		// delete
		@RequestMapping(value="json/Vehicle/delete",produces="application/json")
		public @ResponseBody HashMap<String,Object> delete(Vehicle p) {
			System.out.println(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				VehicleMapper.deleteVehicle(p);
				
				map.put("success", true);
			}catch(Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			
			return map;
		}
		
		// query
		@RequestMapping(value="json/Vehicle/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Vehicle p) {
			logger.info(p);
			HashMap<String,Object> map =  new HashMap<String,Object>();
			try {
				List<Vehicle> list = VehicleMapper.queryVehicle(p);
				Integer count = VehicleMapper.countVehicle(p);
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
		@RequestMapping(value="json/Vehicle/showone",produces="application/json")
		public @ResponseBody Vehicle showone(Vehicle p) {
			logger.info(p);
//			HashMap<String,Object> map =  new HashMap<String,Object>();
			Vehicle p2 = null;
			try {
				p2 = VehicleMapper.selectVehicle(p);
//				map.put("success", true);
//				map.put("Vehicle", p2);
			}catch(Exception e) {
//				map.put("success", false);
				e.printStackTrace();
			}
			return p2;
	}
}
