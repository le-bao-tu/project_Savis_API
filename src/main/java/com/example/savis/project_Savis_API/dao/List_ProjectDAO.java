package com.example.savis.project_Savis_API.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.savis.project_Savis_API.entities.List_Projects;

public interface List_ProjectDAO {
	
	public Page<List_Projects> getListpro(Pageable pageable,Boolean role);
	public boolean insertlistPro(List_Projects listpro);
	public boolean updatelistPro(List_Projects listpro);
	public boolean deletelistPro(Integer listproId);
	public List_Projects getListproById(Integer listproId);
	public List<List_Projects> getByName(String name);
	public boolean updateName(String name,Integer id);

}
