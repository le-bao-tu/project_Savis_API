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

import com.example.savis.project_Savis_API.dao.List_ProjectDAO;
import com.example.savis.project_Savis_API.dto.ServiceResponse;
import com.example.savis.project_Savis_API.entities.List_Projects;
import com.example.savis.project_Savis_API.util.MessageCode;

@RequestMapping("api")
@RestController 
public class List_ProjectResource {
	
	@Autowired List_ProjectDAO list_ProjectDAO;
	
	@GetMapping(value = "list_Project",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Page<List_Projects>> getListpro(Pageable pageable) {
		try {
			return new ServiceResponse<Page<List_Projects>>(MessageCode.SUCCESS,"success",list_ProjectDAO.getListpro(pageable));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Page<List_Projects>>(MessageCode.ERROR,"error",null);
		}
	}
	
	
	@PostMapping(value = "insert/list_Project",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> insertListpro(@RequestBody List_Projects list_Projects) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"insertSuccess",list_ProjectDAO.insertlistPro(list_Projects));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"insertError",false);
		}
	}
	
	
	@PutMapping(value = "update/list_Prpject",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateListpro(@RequestBody List_Projects list_Projects) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"updateSuccess",list_ProjectDAO.updatelistPro(list_Projects));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"errorUpdate",false);
		}
	}
	
	
	@GetMapping(value = "/list_Project/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<List_Projects> getById(@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<List_Projects>(MessageCode.SUCCESS,"sucess",list_ProjectDAO.getListproById(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<List_Projects>(MessageCode.ERROR,"sucess",null);
			
		}
	}
	
	@DeleteMapping(value ="/delete_Listpro/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> deleteListpro(@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"deleteSuccess",list_ProjectDAO.deletelistPro(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"deleteError",false);
		}
	}
	
	@GetMapping(value = "/list_Project/search",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<List_Projects> getByName(@RequestParam("name") String name) {
		try {
			return new ServiceResponse<List_Projects>(MessageCode.SUCCESS,"success",list_ProjectDAO.getByName(name));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<List_Projects>(MessageCode.ERROR,"error",null);
			
		}
	}
	
	

	@PatchMapping(value = "/list_Project/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateName(@RequestParam("name") String name,@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"updateSuccess",list_ProjectDAO.updateName(name, id));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",null);
		}
	}
	
}	


