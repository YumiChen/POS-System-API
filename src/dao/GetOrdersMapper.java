package dao;

import java.util.List;

import vo.OrderResult;
import vo.OrderDetailResult;

public interface GetOrdersMapper {
	
	public List<OrderResult> getOrdersn(OrderResult b);
	public List<OrderResult> getOrderst(OrderResult b);
//	public Integer countOrder(OrderResult b);

	public List<OrderDetailResult> getOrderDetail(OrderDetailResult b);
	
//	public Integer countOrderDetail(OrderDetailResult b);
}
