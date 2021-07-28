package com.voizFonica.app.voizFonica_app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voizFonica.app.forrequirementclasses.UserOrderHistory;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserOrderController {
	@Autowired
	private UserOrderService userOrderService;
	
	@Autowired
	private PlanService planSerivce;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("user-order/get-all-orders")
	public List<UserOrder> getUserOrders() {
		return userOrderService.findAllOrders();
	}
	
	
	private static long invoiceNumber=1;
	public String getInvoiceNumber() {
		LocalDate date = LocalDate.now();
		return date.getYear()+""+date.getMonthValue()+""+date.getDayOfMonth()+""+invoiceNumber++;
	}
	
	@GetMapping("user-order/get-order/{orderId}")
	public ResponseEntity<UserOrderHistory> getOrderByOrderId(@PathVariable Integer orderId) {
		try {
			
			UserOrder userOrder = userOrderService.findById(orderId);
			Plans plan = this.planSerivce.findByPlanId(userOrder.getPlanId());
			Users user = this.userService.findByMobileNumber(userOrder.getUserPhoneNumber());
			UserOrderHistory userOrderInfor = new UserOrderHistory();
			userOrderInfor.setOrderId(userOrder.getOrderId());
			userOrderInfor.setPlanAmount(plan.getPlanAmount());
			userOrderInfor.setPlanDescription(plan.getPlanDescription());
			userOrderInfor.setUserName(user.getUserFirstName()+" "+user.getUserLastName());
			userOrderInfor.setInvoiceNumber(getInvoiceNumber());
			userOrderInfor.setOrderStatus(userOrder.getOrderStatus().equals("y")?"active":"expired");
			userOrderInfor.setRechargedNumber(userOrder.getRechargedNumber());
			userOrderInfor.setPlanActivationDate(userOrder.getPlanActivationDate());
			userOrderInfor.setPlanDuration(plan.getPlanDuration());
			userOrderInfor.setPlanExpiryDate(userOrder.getPlanExpiryDate());
			userOrderInfor.setUserPhoneNumber(userOrder.getUserPhoneNumber());
			return new ResponseEntity<UserOrderHistory>(userOrderInfor,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	@GetMapping("user-order/get-orders-of-user/{userPhoneNumber}")
	public List<UserOrderHistory> getOrdersOfUser(@PathVariable String userPhoneNumber) {
		
		List<UserOrder> userOrderInfo = userOrderService.findByUserPhoneNumber(userPhoneNumber);
		
		List<UserOrderHistory> orderHistory = new ArrayList<>();
		
		for(UserOrder userOrder:userOrderInfo) {
			UserOrderHistory orderInfo = new UserOrderHistory();
			orderInfo.setOrderId(userOrder.getOrderId());
			orderInfo.setOrderStatus(userOrder.getOrderStatus().equals("y")?"active":"expired");
			orderInfo.setRechargedNumber(userOrder.getRechargedNumber());
			orderInfo.setUserPhoneNumber(userOrder.getUserPhoneNumber());
			orderInfo.setPlanActivationDate(userOrder.getPlanActivationDate());
			orderInfo.setPlanExpiryDate(userOrder.getPlanExpiryDate());
			Plans plan = planSerivce.findByPlanId(userOrder.getPlanId());
			orderInfo.setPlanAmount(plan.getPlanAmount());
			orderInfo.setPlanDescription(plan.getPlanDescription());
			
			orderHistory.add(orderInfo);
		}
		
		return orderHistory;
	}
	
	@GetMapping("user-order/get-orders-by-status/{orderStatus}")
	public List<UserOrder> getOrdersOfUserBygetOrdersByStatus(@PathVariable String orderStatus) {
		return userOrderService.findByOrderStatus(orderStatus);
	}
	
	
//	@GetMapping("user-order/get-orders-active-of-user/{userPhoneNumber}") 
//	public List<UserOrder> getActiveOrdersOfUser(@PathVariable String userPhoneNumber) {
//		List<UserOrder> allUserOrders = userOrderService.findByUserPhoneNumber(userPhoneNumber);
//		List<UserOrder> activeOrders = allUserOrders.stream().filter((order)-> order.getOrderStatus().equals("y")).collect(Collectors.toList());
//		return activeOrders;
//	}
	
	
	
	
	@GetMapping("user-order/get-orders-active-of-user/{rechargedNumber}") 
	public List<UserOrder> getActiveOrdersOfUser(@PathVariable String rechargedNumber) {
		List<UserOrder> allUserOrders = userOrderService.findAllByRechargedNumber(rechargedNumber);
		List<UserOrder> activeOrders = allUserOrders.stream().filter((order)-> order.getOrderStatus().equals("y")).collect(Collectors.toList());
		return activeOrders;
	}
	
	
	
	
//	@GetMapping("user-order/get-orders-of-user-product") 
//	public List<UserOrder> getActiveOrdersOfUserProduct(@RequestBody UserOrder userOrder) {
//		List<UserOrder> allUserOrders = userOrderService.findAllByUserPhoneNumberAndRechargedNumberAndOrderStatus(userOrder.getUserPhoneNumber(), userOrder.getRechargedNumber(), userOrder.getOrderStatus());
////		List<UserOrder> activeOrders = allUserOrders.stream().filter((order)-> order.getOrderStatus().equals("y")).collect(Collectors.toList());
//		return allUserOrders;
//	}
	
//	@PostMapping("user-order/add-order")
//	public ResponseEntity<?> addOrder(@RequestBody UserOrder userOrder) {
//		try {
//			userOrderService.addUser(userOrder);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
	
	@PostMapping("user-order/add-order")
	public ResponseEntity<Integer> addOrder(@RequestBody UserOrder userOrder) {
		try {
			LocalDate localDate = LocalDate.now();
			Plans plan = this.planSerivce.findByPlanId(userOrder.getPlanId());
			userOrder.setOrderStatus("y");
			userOrder.setPlanActivationDate(String.valueOf(localDate));
			userOrder.setPlanExpiryDate(String.valueOf(localDate.plusDays(plan.getPlanDuration())));
			userOrderService.addUser(userOrder);
			Integer orderId = userOrderService.findMaxOrderId();
			return new ResponseEntity<Integer>(orderId,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
