package dao;

import java.util.List;

import vo.Stock;

public interface StockMapper {
	public void addStock(Stock b);
	public void modifyStock(Stock b);
	
	public void deleteStock(Stock b);
	
	public Stock selectStock(Stock b);
	
	public List<Stock> queryStock(Stock b);
	
	public Integer countStock(Stock b);
}
