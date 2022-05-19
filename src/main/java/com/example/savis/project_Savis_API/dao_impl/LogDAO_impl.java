package com.example.savis.project_Savis_API.dao_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.dao.LogDAO;
import com.example.savis.project_Savis_API.entities.Log;
import com.example.savis.project_Savis_API.repository.LogRepository;

@Service
public class LogDAO_impl implements LogDAO{
	
	@Autowired LogRepository logRepository;
	
	
	
	@Override
	public boolean insertLog(Log log) {
		// TODO Auto-generated method stub
		try {
			logRepository.save(log);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	
}
