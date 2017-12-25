package dao;

import java.util.List;

import vo.StockRecord;

public interface StockRecordMapper {
	public void addStockRecord(StockRecord b);
	public void modifyStockRecord(StockRecord b);
	
	public void deleteStockRecord(StockRecord b);
	
	public StockRecord selectStockRecord(StockRecord b);
	
	public List<StockRecord> queryStockRecord(StockRecord b);
	
	public Integer countStockRecord(StockRecord b);
}
