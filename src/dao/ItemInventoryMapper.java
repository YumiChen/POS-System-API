package dao;

import java.util.List;

import vo.ItemInventory;

public interface ItemInventoryMapper {
	public List<ItemInventory> queryItemInventory(ItemInventory b);
	public List<ItemInventory> queryInventoryLoss(ItemInventory b);
	public List<ItemInventory> queryInventoryAll(ItemInventory b);
}