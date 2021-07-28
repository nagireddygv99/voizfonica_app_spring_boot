package com.voizFonica.app.voizFonica_app;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderService {
	@Autowired
	private UserOrderRepository userOrderRepo;
	
	public List<UserOrder> findAllOrders() {
		return userOrderRepo.findAll();
	}

	public List<UserOrder> findByOrderStatus(String orderStatus) {
		return this.userOrderRepo.findAllByOrderStatus(orderStatus);
	}
	
	public List<UserOrder> findByUserPhoneNumber(String userPhoneNumber) {
		return this.userOrderRepo.findAllByUserPhoneNumber(userPhoneNumber);
	}
	
	public void addUser(UserOrder userOrder) {
		userOrderRepo.save(userOrder);
	}
	public UserOrder findById(Integer orderId) {
		return userOrderRepo.findById(orderId).get();
	}
	
	public void madePlansExpired() {
		LocalDate localDate = LocalDate.now();
		this.userOrderRepo.makePlanExpired(String.valueOf(localDate));
	}
	
	public Integer findMaxOrderId() {
		return this.userOrderRepo.findMaxOrderId();
	}
	
	public List<UserOrder> findAllByUserPhoneNumberAndRechargedNumberAndOrderStatus(String userPhoneNumber,String rechargedNumber,String orderStatus) {
		return this.userOrderRepo.findAllByUserPhoneNumberAndRechargedNumberAndOrderStatus(userPhoneNumber, rechargedNumber, orderStatus);
	}
	
	public List<UserOrder> findAllByRechargedNumber(String rechargedNumber) {
		return this.userOrderRepo.findAllByRechargedNumber(rechargedNumber);
	}
	 
}
