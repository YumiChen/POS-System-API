package dao;

import java.util.List;

import vo.Order;

public interface OrderMapper {
	public void addOrder0(Order b);
	public  void addOrder1(Order b);
	public  String selectId();
	
	public void modifyOrder0(Order b);
	public void modifyOrder1(Order b);
	
	public void deleteOrder(Order b);
	
	public Order selectOrder(Order b);
	
	public List<Order> queryOrder(Order b);
	
	public Integer countOrder(Order b);
	
	public void validateornot(Order b);
	
}
