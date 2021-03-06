package com.example.savis.project_Savis_API.endpoint;

import java.util.List;

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

import com.example.savis.project_Savis_API.dao.List_WorkDAO;
import com.example.savis.project_Savis_API.dto.ServiceResponse;
import com.example.savis.project_Savis_API.entities.List_Work;
import com.example.savis.project_Savis_API.util.MessageCode;


@RequestMapping("api")
@RestController 
public class List_WorkResource {
	
	
	@Autowired List_WorkDAO list_WorkDAO;
	
	@GetMapping(value = "list_work",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Page<List_Work>> getListwork(Pageable pageable,@RequestParam("status") Boolean status) {
		try {
			return new ServiceResponse<Page<List_Work>>(MessageCode.SUCCESS,"success",list_WorkDAO.getList_Word(pageable,status));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Page<List_Work>>(MessageCode.ERROR,"error",null);
		}
	}
	
	@PostMapping(value = "insert/{listproId}/listwork" , produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> insertlistwork(@PathVariable("listproId") Integer id , @RequestBody List_Work list_Work ) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"insertSuccess",list_WorkDAO.insertWork(id, list_Work));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"insertSuccess",false);
		}
	}
	
	
	
	@PutMapping(value = "update/{listproId}/listwork" , produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updatelistwork(@PathVariable("listproId") Integer id , @RequestBody List_Work list_Work ) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"insertSuccess",list_WorkDAO.updateWork(id, list_Work));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"insertSuccess",false);
		}
	}
	
	
	
	@PatchMapping(value = "updateStatsus/{id}/listwork",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateStatsus(@RequestParam("status") Boolean status , @PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"updateSuccess",list_WorkDAO.updateStatus(status, id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"errorUpdate",false);
		}
	}
	
	
	
	@DeleteMapping(value = "delete/{id}/listwork", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> deletelistwork(@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"deleteSuccess",list_WorkDAO.deleteWork(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"erordeleter",false);
		}
	}
	
	
	@GetMapping(value = "/listwork/search",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<List<List_Work>> searchByName(@RequestParam("name") String name) {
		try {
			return new ServiceResponse<List<List_Work>>(MessageCode.SUCCESS,"success",list_WorkDAO.getSearchByName(name));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<List<List_Work>>(MessageCode.SUCCESS,"error",null);
		}
	}
	
}
