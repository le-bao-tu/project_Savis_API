package com.example.savis.project_Savis_API.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.List_Projects;


@Repository
public interface List_ProjectRepository extends JpaRepository<List_Projects, Integer>{
	
	List_Projects findByName(String name);
	
	Page<List_Projects> findByRole(Pageable pageable,Boolean role);
	
	@Query(value = "select * from List_Project where (:name is null or Name like %:name%)",nativeQuery = true)
	List<List_Projects> listSearch(@Param("name") String name);
}
