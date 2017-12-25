package dao;

//import java.util.HashMap;
import java.util.List;

import vo.Analysis;
import vo.AnalysisResult;

public interface AnalysisMapper {
//	public List<AnalysisResult> queryAnalysis( Analysis b);
//	public Integer countAnalysis( Analysis b);
//	
//	public List<AnalysisResult> queryWholeMonths( Analysis b);
//	public Integer countWholeMonths( Analysis b);
//	public List<AnalysisResult> queryWholeYears( Analysis b);
//	public Integer countWholeYears( Analysis b);
//	public List<AnalysisResult> queryInMonth( Analysis b);
//	public Integer countInMonth( Analysis b);
	
	public List<AnalysisResult> queryInMonth( Analysis b);
	public List<AnalysisResult> queryCrossMonth( Analysis b);
	public List<AnalysisResult> queryCrossYear( Analysis b);
	
	public List<AnalysisResult> queryInMonthByCategory( Analysis b);
	public List<AnalysisResult> queryCrossMonthByCategory( Analysis b);
	public List<AnalysisResult> queryCrossYearByCategory( Analysis b);
	
	public List<AnalysisResult> queryInMonthByItem( Analysis b);
	public List<AnalysisResult> queryCrossMonthByItem( Analysis b);
	public List<AnalysisResult> queryCrossYearByItem( Analysis b);
}
