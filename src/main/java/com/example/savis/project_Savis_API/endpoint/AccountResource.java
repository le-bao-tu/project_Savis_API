package com.example.savis.project_Savis_API.endpoint;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.savis.project_Savis_API.dao.AccountDAO;
import com.example.savis.project_Savis_API.dto.ServiceResponse;
import com.example.savis.project_Savis_API.entities.Account;
//import com.example.savis.project_Savis_API.entities.List_Projects;
import com.example.savis.project_Savis_API.util.MessageCode;

@RequestMapping("api")
@RestController
public class AccountResource {
	
	@Autowired 
	AccountDAO accountDAO;
	
	@GetMapping(value = "/account",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Page<Account>> getListAccount(Pageable pageable){
		try {
			return new ServiceResponse<Page<Account>>(MessageCode.SUCCESS,"Seccess",accountDAO.getListAccount(pageable));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Page<Account>>(MessageCode.ERROR,"Error",accountDAO.getListAccount(pageable));
		}
	}
	@PostMapping(value = "/register/account",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> registerAccount(@RequestBody Account account){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"Seccess",accountDAO.registerAccount(account));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"Error",false);
		}
	}
	@PutMapping(value = "/update/account",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateAccount(@RequestBody Account account){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"Seccess",accountDAO.updateAccountt(account));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"Error",false);
		}
	}
	@DeleteMapping(value = "/deleteAccount/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> deleteAccount(@PathVariable("id") Integer id){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"deleteSuccess",accountDAO.deleteAccount(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"deleteError",false);
		}
	}
	@GetMapping(value = "/account/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Account> getById(@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Account>(MessageCode.SUCCESS,"sucess",accountDAO.getListAccById(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Account>(MessageCode.ERROR,"sucess",null);
		}
	}
	@GetMapping(value = "/account/search",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<List<Account>> getByName(@RequestParam("name") String name) {
		try {
			return new ServiceResponse<List<Account>>(MessageCode.SUCCESS,"success",accountDAO.getByName(name));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<List<Account>>(MessageCode.ERROR,"error",null);
			
		}
	}
	@PatchMapping(value = "/account/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateName(@RequestParam("name") String name,@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"updateSuccess",accountDAO.updateName(name, id));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",null);
		}
	}
}
