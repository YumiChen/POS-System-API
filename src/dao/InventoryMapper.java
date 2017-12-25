package dao;

import java.util.List;

import vo.Inventory;

public interface InventoryMapper {
public void addInventory(Inventory b);
	
	public void modifyInventory(Inventory b);
	
	public void deleteInventory(Inventory b);
	
	public Inventory selectInventory(Inventory b);
	
	public List<Inventory> queryInventory(Inventory b);
	
	public Integer countInventory(Inventory b);
}
