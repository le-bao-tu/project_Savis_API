package com.example.savis.project_Savis_API.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
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

import com.example.savis.project_Savis_API.dao.User_ListWorkDAO;
import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.dto.ServiceResponse;
import com.example.savis.project_Savis_API.entities.User_ListWork;
import com.example.savis.project_Savis_API.util.MessageCode;
import com.example.savis.project_Savis_API.util.userRequest;


@RequestMapping("api")
@RestController 
public class User_ListWorkResource {
	
	@Autowired User_ListWorkDAO user_ListWorkDAO;
	
	@GetMapping(value = "/user_ListWork",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Page<User_ListWork>> getUserListWork(Pageable pageable,@RequestParam("status")Boolean status) {
		try {
//			Pageable pageable = PageRequest.of(page, size);
//			return user_ListWorkDAO.getUser_ListWorkCustom(pageable);
			return new ServiceResponse<Page<User_ListWork>>(MessageCode.SUCCESS,"success",user_ListWorkDAO.getUser_ListWork(pageable,status));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Page<User_ListWork>>(MessageCode.ERROR,"error",null);
		}
	}
	
	
	@PostMapping(value ="/getUser")
	public ResonpeBodyDto getUser(@RequestBody userRequest request) {
//		ResonpeBodyDto rs = new ResonpeBodyDto<>();
		return user_ListWorkDAO.getUser_ListWorkCustom(request);
	}
	
	
	
	
	@PostMapping(value = "/insertUser_listWork/{list_WorkId}and/{accountId}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> insertlist_User(@PathVariable("list_WorkId")Integer listWorkId,@PathVariable("accountId")Integer accountId,@RequestBody User_ListWork user_ListWork) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"success",user_ListWorkDAO.InsertUserListWork(listWorkId, accountId, user_ListWork));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",false);
		}
	}
	
	@PutMapping(value = "/UpdateUser_listWork/{list_WorkId}and/{accountId}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> Updatelist_User(@PathVariable("list_WorkId")Integer listWorkId,@PathVariable("accountId")Integer accountId,@RequestBody User_ListWork user_ListWork) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"success",user_ListWorkDAO.UpdateUserListWork(listWorkId, accountId, user_ListWork));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",false);
		}
	}
	
	
	@PatchMapping(value = "updateStatus/{id}/userListWork",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateStatus(@RequestParam("status")Boolean status,@PathVariable("id")Integer id){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"updateSuccess",user_ListWorkDAO.updateStatus(status, id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"errorUpdate",false);
		}
	}
	
	
	@DeleteMapping(value = "delete/{id}/userListWork",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> delete(@PathVariable("id")Integer id){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"deleteSuccess",user_ListWorkDAO.DeleteUserListWork(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"erordeleter",false);
		}
	}
}
