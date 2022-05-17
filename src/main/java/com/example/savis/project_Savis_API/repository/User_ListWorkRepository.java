package com.example.savis.project_Savis_API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.User_ListWork;

@Repository
public interface User_ListWorkRepository extends JpaRepository<User_ListWork, Integer> {
		
	Page<User_ListWork> findByStatus(Pageable pageable,Boolean status);
}	
	