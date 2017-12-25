package dao;

import java.util.List;

import vo.Sale;

public interface SaleMapper {
public void addSale(Sale b);
	
	public void modifySale(Sale b);
	
	public void deleteSale(Sale b);
	
	public Sale selectSale(Sale b);
	
	public List<Sale> querySale(Sale b);
	
	public Integer countSale(Sale b);
}
