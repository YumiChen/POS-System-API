package dao;

import java.util.List;

import vo.OrderStatus;

public interface OrderStatusMapper {
public void addOrderStatus(OrderStatus b);
	
	public void modifyOrderStatus(OrderStatus b);
	
	public void deleteOrderStatus(OrderStatus b);
	
	public OrderStatus selectOrderStatus(OrderStatus b);
	
	public List<OrderStatus> queryOrderStatus(OrderStatus b);
	
	public Integer countOrderStatus(OrderStatus b);
}
