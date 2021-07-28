package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
	public List<UserOrder> findAllByOrderStatus(String orderStatus);
	
	public List<UserOrder> findAllByUserPhoneNumber(String userPhoneNumber);
	
	@Query("update UserOrder uo set uo.orderStatus='n' where uo.planExpiryDate < ?1")
	public void makePlanExpired(String date);
	
	@Query("select max(uo.orderId) from UserOrder uo")
	public Integer findMaxOrderId();
	
	@Query("select uo from UserOrder uo where uo.userPhoneNumber=?1 and uo.rechargedNumber=?2 and uo.orderStatus=?3")
	public List<UserOrder> findAllByUserPhoneNumberAndRechargedNumberAndOrderStatus(String userPhoneNumber,String rechargedNumber,String orderStatus);
	
	@Query("select uo from UserOrder uo where uo.rechargedNumber=?1")
	public List<UserOrder> findAllByRechargedNumber(String rechargedNumber);
}
