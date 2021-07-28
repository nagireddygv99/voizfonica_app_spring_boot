package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plans, Integer> {
	
//	 public Plans findByPlanId(int planId);
	 
	 public List<Plans> findByProductId(int productId);

}
