package com.example.savis.project_Savis_API.dao_impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.dao.List_WorkDAO;
import com.example.savis.project_Savis_API.entities.List_Work;
import com.example.savis.project_Savis_API.repository.List_ProjectRepository;
import com.example.savis.project_Savis_API.repository.List_WorkRepository;


@Service
public class List_WorkDAO_impl implements List_WorkDAO{
	
	@Autowired List_ProjectRepository list_ProjectRepository;
	
	@Autowired List_WorkRepository list_WorkRepository;
	
	@Override
	public Page<List_Work> getList_Word(Pageable pageable,Boolean role) {
		// TODO Auto-generated method stub
		try {
			return list_WorkRepository.findByRole(pageable,role);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean insertWork(Integer list_projectId, List_Work list_work) {
		// TODO Auto-generated method stub
		
		try {
			 list_work.setList_Projects(list_ProjectRepository.findById(list_projectId).get());
			 list_WorkRepository.save(list_work);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
			
		}
	}

	
	
	@Override
	public boolean updateWork(Integer list_projectId, List_Work list_work) {
		// TODO Auto-generated method stub
		try {
			list_work.setList_Projects(list_ProjectRepository.findById(list_projectId).get());
			list_WorkRepository.save(list_work);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	public boolean deleteWork(Integer listworkId) {
		// TODO Auto-generated method stub
		try {
			
			list_WorkRepository.deleteById(listworkId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	
	


	@Override
	public List<List_Work> getSearchByName(String name) {
		// TODO Auto-generated method stub
		try {
			return list_WorkRepository.listSearch(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List_Work getListWorkById(Integer id) {
		// TODO Auto-generated method stub
		try {
			return list_WorkRepository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@Transactional
	public boolean soft_Erase(Integer id) {
		try {
			Optional<List_Work> list_Work = list_WorkRepository.findById(id);
			if(list_Work.isPresent() && list_Work.get().getRole() != false) {
				list_Work.get().setRole(false);;
			}else {
				System.err.println("error");
			}
			list_WorkRepository.save(list_Work.get());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	
	
	
		
}
