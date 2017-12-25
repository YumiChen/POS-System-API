package dao;

import java.util.List;

import vo.ItemStock;
import vo.ItemStockSearch;

public interface ItemStockMapper {
	
//	public ItemStock selectItemStock(ItemStock b);
	public List<ItemStock> queryItemStock(ItemStock b);
	public List<ItemStock> searchItemStock(ItemStockSearch p);
//	public Integer countItemStock(ItemStock b);
}
