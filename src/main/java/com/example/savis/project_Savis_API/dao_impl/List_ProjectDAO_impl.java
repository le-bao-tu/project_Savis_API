	package com.example.savis.project_Savis_API.dao_impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.dao.List_ProjectDAO;
import com.example.savis.project_Savis_API.entities.List_Projects;
import com.example.savis.project_Savis_API.repository.List_ProjectRepository;

@Service
public class List_ProjectDAO_impl implements List_ProjectDAO{
	
	@Autowired List_ProjectRepository list_ProjectRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(List_ProjectDAO_impl.class);
	
	@Override
	public Page<List_Projects> getListpro(Pageable pageable,Boolean role) {
		// TODO Auto-generated method stub
		try {
			
			LOGGER.info("you have retrieved the list of records");
			
			return list_ProjectRepository.findByRole(pageable, role);
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("error");
			
			e.printStackTrace();
			return null;
			
		}
	}

	
	
	@Override
	public boolean insertlistPro(List_Projects listpro) {
		// TODO Auto-generated method stub
		try {
			list_ProjectRepository.save(listpro);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatelistPro(List_Projects listpro) {
		// TODO Auto-generated method stub
		try {
			list_ProjectRepository.save(listpro);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deletelistPro(Integer listproId) {
		// TODO Auto-generated method stub
		try {
			list_ProjectRepository.deleteById(listproId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List_Projects getListproById(Integer listproId) {
		// TODO Auto-generated method stub
		try {
			return list_ProjectRepository.findById(listproId).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<List_Projects> getByName(String name) {
		// TODO Auto-generated method stub
		try {
			return list_ProjectRepository.listSearch(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateName(String name, Integer id) {
		// TODO Auto-generated method stub
		try {
			List_Projects listpro = list_ProjectRepository.getById(id);
			listpro.setName(name);
			list_ProjectRepository.save(listpro);			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}



	
}
