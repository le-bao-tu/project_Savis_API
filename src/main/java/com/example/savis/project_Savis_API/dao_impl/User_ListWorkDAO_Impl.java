package com.example.savis.project_Savis_API.dao_impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.dao.User_ListWorkDAO;
import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.entities.Account;
import com.example.savis.project_Savis_API.entities.List_Work;
import com.example.savis.project_Savis_API.entities.User_ListWork;
import com.example.savis.project_Savis_API.repository.AccountRepository;
import com.example.savis.project_Savis_API.repository.List_WorkRepository;
import com.example.savis.project_Savis_API.repository.User_ListWorkRepository;
import com.example.savis.project_Savis_API.util.userRequest;


@Service
public class User_ListWorkDAO_Impl implements User_ListWorkDAO {

	@Autowired User_ListWorkRepository user_ListWorkRepository;
	@Autowired List_WorkRepository list_WorkRepository;
	@Autowired AccountRepository accountRepository;
	
	@Override
	public Page<User_ListWork> getUser_ListWork(Pageable pageable,Boolean status) {
		try {
			return user_ListWorkRepository.findAll(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}




	@Override
	@Transactional
	public Boolean InsertUserListWork(Integer listWorkId,Integer accountId,User_ListWork user_ListWork) {
		// TODO Auto-generated method stub
		User_ListWork rs= null;
		try {
			Optional<List_Work>  listWork = list_WorkRepository.findById(listWorkId);
			Optional<Account>  account = accountRepository.findById(accountId);
			if(listWork.isPresent()&& account.isPresent()) {
				List_Work a = listWork.get();
				Account b = account.get();
				 rs = new User_ListWork(null, user_ListWork.getStatus(),b,a);
			}
			user_ListWorkRepository.save(rs);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public ResonpeBodyDto getUser_ListWorkCustom(userRequest request) {
		ResonpeBodyDto rs = new  ResonpeBodyDto();
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
		Page<User_ListWork> lst = user_ListWorkRepository.findAll(pageable);
		if(lst != null) {
			rs.setMessage("get data success");
			rs.setMessageCode("200");
			rs.setPageNumber(lst.getNumberOfElements());
			rs.setData(lst.getContent());
		}else
		{
			rs.setMessage("get data failure");
			rs.setMessageCode("400");
			rs.setPageNumber(lst.getNumberOfElements());
			rs.setData(new User_ListWork());
		}
		
		return rs;
	}




	@Override
	public Boolean UpdateUserListWork(Integer listWorkId, Integer accountId, User_ListWork user_ListWork) {
		User_ListWork rs= null;
		try {
			Optional<List_Work>  listWork = list_WorkRepository.findById(listWorkId);
			Optional<Account>  account = accountRepository.findById(accountId);
			if(listWork.isPresent()&& account.isPresent()) {
				List_Work a = listWork.get();
				Account b = account.get();
				 rs = new User_ListWork(user_ListWork.getId(), user_ListWork.getStatus(),b,a);
			}
			user_ListWorkRepository.save(rs);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public Boolean DeleteUserListWork(Integer user_ListWorkId) {
		try {
			user_ListWorkRepository.deleteById(user_ListWorkId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public boolean updateStatus(Boolean status, Integer id) {
		try {
			User_ListWork user_ListWork = user_ListWorkRepository.getById(id);
			user_ListWork.setStatus(status);
			user_ListWorkRepository.save(user_ListWork);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}	
