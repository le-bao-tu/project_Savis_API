package com.example.savis.project_Savis_API.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.List_Work;

@Repository
public interface List_WorkRepository extends JpaRepository<List_Work, Integer>{
	
	List_Work findByName(String name);
	
	Page<List_Work> findByRole(Pageable pageable,Boolean role);
	
	
	@Query(value = "select * from List_Work where (:name is null or Name like %:name%)",nativeQuery = true)
	List<List_Work> listSearch(@Param("name") String name);
	
}
