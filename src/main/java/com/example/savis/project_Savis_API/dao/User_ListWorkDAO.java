package com.example.savis.project_Savis_API.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.dto.userRequest;
import com.example.savis.project_Savis_API.entities.User_ListWork;

public interface User_ListWorkDAO {
	public Page<User_ListWork> getUser_ListWork(Pageable pageable,Boolean status);

	ResonpeBodyDto getUser_ListWorkCustom(userRequest request);

	public Boolean InsertUserListWork(Integer listWorkId, Integer accountId, User_ListWork user_ListWork);
	public Boolean UpdateUserListWork(Integer listWorkId, Integer accountId, User_ListWork user_ListWork);
	public Boolean DeleteUserListWork(Integer user_ListWorkId);
	public boolean updateStatus(Boolean status , Integer id);
}
