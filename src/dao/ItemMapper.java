package dao;

import java.util.List;

import vo.Item;

public interface ItemMapper {
public void addItem(Item b);
	
	public void modifyItem(Item b);
	
	public void deleteItem(Item b);
	
	public Item selectItem(Item b);
	
	public List<Item> queryItem(Item b);
	
	public Integer countItem(Item b);
}
