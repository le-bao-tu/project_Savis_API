package com.example.savis.project_Savis_API.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.savis.project_Savis_API.Model.List_Work_ResourceModel;
import com.example.savis.project_Savis_API.entities.List_Work;

public interface List_WorkDAO {
	
	public Page<List_Work> getList_Word(Pageable pageable,Boolean role);
	public boolean insertWork(List_Work_ResourceModel list_work);
	public boolean updateWork(List_Work_ResourceModel list_work);
	public boolean deleteWork(Integer listworkId);
	public List_Work getListWorkById(Integer id);
	public List<List_Work> getSearchByName(String name);
	public boolean soft_Erase(Integer id);

	
}