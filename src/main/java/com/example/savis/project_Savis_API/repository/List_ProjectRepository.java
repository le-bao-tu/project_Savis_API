package com.example.savis.project_Savis_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.List_Projects;


@Repository
public interface List_ProjectRepository extends JpaRepository<List_Projects, Integer>{
	
	List_Projects findByName(String name);
}
