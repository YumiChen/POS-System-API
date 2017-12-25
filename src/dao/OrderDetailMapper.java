package dao;

import java.util.List;

import vo.OrderDetail;

public interface OrderDetailMapper {
public void addOrderDetail(OrderDetail b);
	
	public void modifyOrderDetail(OrderDetail b);
	
	public void deleteOrderDetail(OrderDetail b);
	
	public OrderDetail selectOrderDetail(OrderDetail b);
	
	public List<OrderDetail> queryOrderDetail(OrderDetail b);
	
	public Integer countOrderDetail(OrderDetail b);
}
