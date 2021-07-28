package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepo;
	
	public List<Plans> findAll() {
		return planRepo.findAll();
	}
	
	public Plans findByPlanId(int planId) {
		return planRepo.findById(planId).get();
	}	
	
	public List<Plans> findByProductId(int productId) {
		return planRepo.findByProductId(productId);
	}
	
	public void addPlan(Plans plan) {
		planRepo.save(plan);
	}
	
	public void deletePlan(int planId) {
		planRepo.deleteById(planId);
	}
	
}
