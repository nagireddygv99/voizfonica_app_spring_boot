package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserProductRepository extends JpaRepository<UserProduct,Integer> {
	@Query("select up from UserProduct up where up.userPhoneNumber=?1")
	List<UserProduct> findAllById(String userPhoneNumber);
	
	@Query("select up from UserProduct up where up.userPhoneNumber=?1 and up.userNumber=?2")
	UserProduct findUserProductIsExists(String userPhoneNumber, String userNumber);

}
