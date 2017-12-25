package com.tcg.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.log.Log;

import dao.AnalysisMapper;
import vo.Analysis;
import vo.AnalysisResult;

@Controller
public class AnalysisAction {
	@Autowired
	AnalysisMapper analysisMapper;
	Logger logger = Logger.getLogger(AnalysisAction.class);
	
		// query
		@RequestMapping(value="json/Analysis/query",produces="application/json")
		public @ResponseBody HashMap<String,Object> qr(Analysis p) {
			logger.info(p);
			HashMap<String,Object> result =  new HashMap<String,Object>();
			List<AnalysisResult> list;
			Integer count = -1;
			
			try {
				
				if(p.getStartyear() > p.getEndyear()) {
					throw new Exception();
				}else if(p.getStartyear() == p.getEndyear() && p.getStartmonth() > p.getEndmonth()){
					throw new Exception();
				}else if(p.getStartyear() == p.getEndyear() && p.getStartmonth() == p.getEndmonth() && p.getStartday() > p.getEndday()){
					throw new Exception();
				}
				
			}catch(Exception e) {
				result.put("success", false);
				e.printStackTrace();
			}
			
			if(p.getStartyear() != p.getEndyear()) {
				// 跨越年份
				try {
					list = analysisMapper.queryCrossYear(p);
					count = list.size();
					
					result.put("success", true);
					result.put("list", list);
					result.put("count", count);
					
					System.out.println("Cross year");
				}catch(Exception e) {
					result.put("success", false);
					e.printStackTrace();
				}
			}else if( p.getStartyear()==p.getEndyear() && p.getStartmonth()!=p.getEndmonth()) {
				// 跨越月份
				try {
					list = analysisMapper.queryCrossMonth(p);
					count = list.size();
					
					result.put("success", true);
					result.put("list", list);
					result.put("count", count);
					
					System.out.println("Cross month");
				}catch(Exception e) {
					result.put("success", false);
					e.printStackTrace();
				}
			}else  if( p.getStartyear()==p.getEndyear() && p.getStartmonth()==p.getEndmonth()){
				try {
					list = analysisMapper.queryInMonth(p);
					count = list.size();
					result.put("success", true);
					result.put("list", list);
					result.put("count", count);
					
					System.out.println("in month");
				}catch(Exception e) {
					result.put("success", false);
					e.printStackTrace();
				}
			}
			return result;
		}
		
		// query category
				@RequestMapping(value="json/AnalysisByCategory/query",produces="application/json")
				public @ResponseBody HashMap<String,Object> qrr(Analysis p) {
					logger.info(p);
					HashMap<String,Object> result =  new HashMap<String,Object>();
					List<AnalysisResult> list;
					Integer count = -1;
					
					try {
						if(p.getStartyear() > p.getEndyear()) {
							throw new Exception();
						}
					}catch(Exception e) {
						result.put("success", false);
						e.printStackTrace();
					}
					
					if(p.getStartyear() != p.getEndyear()) {
						// 跨越年份
						try {
							list = analysisMapper.queryCrossYearByCategory(p);
							count = list.size();
							
							result.put("success", true);
							result.put("list", list);
							result.put("count", count);
							
							System.out.println("Cross year");
						}catch(Exception e) {
							result.put("success", false);
							e.printStackTrace();
						}
					}else if( p.getStartyear()==p.getEndyear() && p.getStartmonth()!=p.getEndmonth()) {
						// 跨越月份
						try {
							list = analysisMapper.queryCrossMonthByCategory(p);
							count = list.size();
							
							result.put("success", true);
							result.put("list", list);
							result.put("count", count);
							
							System.out.println("Cross month");
						}catch(Exception e) {
							result.put("success", false);
							e.printStackTrace();
						}
					}else  if( p.getStartyear()==p.getEndyear() && p.getStartmonth()==p.getEndmonth()){
						try {
							list = analysisMapper.queryInMonthByCategory(p);
							count = list.size();
							result.put("success", true);
							result.put("list", list);
							result.put("count", count);
							
							System.out.println("in month");
						}catch(Exception e) {
							result.put("success", false);
							e.printStackTrace();
						}
					}
					return result;
				}
				
				// query item
				@RequestMapping(value="json/AnalysisByItem/query",produces="application/json")
				public @ResponseBody HashMap<String,Object> qrrr(Analysis p) {
					logger.info(p);
					HashMap<String,Object> result =  new HashMap<String,Object>();
					List<AnalysisResult> list;
					Integer count = -1;
					
					try {
						if(p.getStartyear() > p.getEndyear()) {
							throw new Exception();
						}
					}catch(Exception e) {
						result.put("success", false);
						e.printStackTrace();
					}
					
					if(p.getStartyear() != p.getEndyear()) {
						// 跨越年份
						try {
							list = analysisMapper.queryCrossYearByItem(p);
							count = list.size();
							
							result.put("success", true);
							result.put("list", list);
							result.put("count", count);
							
							System.out.println("Cross year");
						}catch(Exception e) {
							result.put("success", false);
							e.printStackTrace();
						}
					}else if( p.getStartyear()==p.getEndyear() && p.getStartmonth()!=p.getEndmonth()) {
						// 跨越月份
						try {
							list = analysisMapper.queryCrossMonthByItem(p);
							count = list.size();
							
							result.put("success", true);
							result.put("list", list);
							result.put("count", count);
							
							System.out.println("Cross month");
						}catch(Exception e) {
							result.put("success", false);
							e.printStackTrace();
						}
					}else  if( p.getStartyear()==p.getEndyear() && p.getStartmonth()==p.getEndmonth()){
						try {
							list = analysisMapper.queryInMonthByItem(p);
							count = list.size();
							result.put("success", true);
							result.put("list", list);
							result.put("count", count);
							
							System.out.println("in month");
						}catch(Exception e) {
							result.put("success", false);
							e.printStackTrace();
						}
					}
					return result;
				}
}
