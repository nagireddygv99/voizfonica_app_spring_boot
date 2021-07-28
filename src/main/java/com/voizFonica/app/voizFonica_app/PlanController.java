package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PlanController {
	@Autowired
	private PlanService planService;
	
	@GetMapping("/plan/get-all-plans")
	public List<Plans> getAllPlans() {
		return planService.findAll();
	}
	
	@GetMapping("/plan/get-plan-by-plan-id/{planId}")
	public ResponseEntity<Plans> getPlanDataById(@PathVariable int planId) {
		try {
			Plans plan = planService.findByPlanId(planId);
			return new ResponseEntity<Plans>(plan,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/plan/get-plans-for-a-product/{productId}")
	public List<Plans> getAllPlansForAProduct(@PathVariable int productId) {
		return planService.findByProductId(productId);
	}
	
	@PostMapping("/plan/add-plan") 
	public ResponseEntity<?> addPlan(@RequestBody Plans plan) {
		try {
			Plans exstPlan = planService.findByPlanId(plan.getPlanId());
			if(exstPlan!=null) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			planService.addPlan(plan);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			planService.addPlan(plan);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/plan/delete-plan/{planId}")
	public ResponseEntity<?> deletePlan(@PathVariable int PlanId) {
		try {
			Plans planExst = planService.findByPlanId(PlanId);
			if(planExst!=null) {
				planService.deletePlan(PlanId);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
		
}
