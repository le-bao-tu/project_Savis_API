package com.example.savis.project_Savis_API.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.savis.project_Savis_API.entities.Account;

public interface AccountDAO {
	
	public Page<Account> getListAccount(Pageable pageable);
	public boolean registerAccount(Account account);
	public boolean updateAccountt(Account account);
	public boolean deleteAccount(Integer accId);
	public Account getListAccById(Integer accId);
	public List<Account> getByName(String name);
	public boolean updateName(String name,Integer id);
}
