package com.example.savis.project_Savis_API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.List_Work;

@Repository
public interface List_WorkRepository extends JpaRepository<List_Work, Integer>{
	
	List_Work findByName(String name);
	Page<List_Work> findByStatus(Pageable pageable,Boolean status);
	
}
