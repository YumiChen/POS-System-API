package dao;

import java.util.List;

import vo.SaleRecord;

public interface SaleRecordMapper {
	public void addSaleRecord(SaleRecord b);
	public void modifySaleRecord(SaleRecord b);
	
	public void deleteSaleRecord(SaleRecord b);
	
	public SaleRecord selectSaleRecord(SaleRecord b);
	
	public List<SaleRecord> querySaleRecord(SaleRecord b);
	
	public Integer countSaleRecord(SaleRecord b);
}
