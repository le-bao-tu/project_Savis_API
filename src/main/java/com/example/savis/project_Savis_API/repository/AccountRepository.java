package com.example.savis.project_Savis_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByName(String name);
	
	@Query(value ="select * from account where (:name is null or Name like %:name%)",nativeQuery=true)
	List<Account> lst(@Param("name")String name);
}
