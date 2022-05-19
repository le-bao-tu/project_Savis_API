package com.example.savis.project_Savis_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer>{

}
