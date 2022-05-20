package com.example.savis.project_Savis_API.dao_impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.Config.AES;
import com.example.savis.project_Savis_API.dao.AccountDAO;
import com.example.savis.project_Savis_API.entities.Account;
import com.example.savis.project_Savis_API.entities.List_Projects;
import com.example.savis.project_Savis_API.repository.AccountRepository;

@Service
public class AccountDAO_impl implements AccountDAO {
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Override
	public Page<Account> getListAccount(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			return accountRepository.findAll(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	@Override
	public boolean registerAccount(Account account) {
		// TODO Auto-generated method stub
		try {
			account.setPassword(AES.encrypt(account.getPassword(),"lebaotu@gmail.com"));
			accountRepository.save(account);
			return true; 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAccountt(Account account) {
		// TODO Auto-generated method stub
		try {
			accountRepository.save(account);
			return true; 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAccount(Integer accId) {
		// TODO Auto-generated method stub
		try {
			accountRepository.deleteById(accId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Account getListAccById(Integer accId) {
		// TODO Auto-generated method stub
		try {
			return accountRepository.findById(accId).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Account> getByName(String name) {
		// TODO Auto-generated method stub
		try {
			return accountRepository.lst(name);
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
			Account account = accountRepository.getById(id);
			account.setName(name);
			accountRepository.save(account);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
}
