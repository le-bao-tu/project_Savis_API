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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.savis.project_Savis_API.Model.Commnet_ResourceModel;
import com.example.savis.project_Savis_API.dao.CommentDAO;
import com.example.savis.project_Savis_API.dto.ServiceResponse;
import com.example.savis.project_Savis_API.entities.Comment;
import com.example.savis.project_Savis_API.util.MessageCode;

@RequestMapping("api")
@RestController
public class CommentResource {
	@Autowired CommentDAO commentDAO;
	
	@GetMapping(value = "/comment_List",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Page<Comment>> getComment(Pageable pageable,@RequestParam("role")Boolean role){
		try {
			return new ServiceResponse<Page<Comment>>(MessageCode.SUCCESS,"Seccess",commentDAO.getComment(pageable, role));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Page<Comment>>(MessageCode.ERROR,"Seccess",null);
		}
	}
	
	@PostMapping(value = "/insertComment",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> insertComment(@RequestBody Commnet_ResourceModel comment){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"success",commentDAO.InsertComment(comment));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",false);
		}
	}
	
	
	@PatchMapping(value =  "updateTitle/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> updateTitle(@RequestParam("title")String title,@PathVariable("id")Integer id){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"updateSuccess",commentDAO.UpdateComment(title, id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"errorUpdate",false);
		}
	}
	
	//xóa cứng 	
	@DeleteMapping(value =  "deleteComment/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> deleteComment(@PathVariable("id")Integer id){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"deleteSuccess",commentDAO.DeleteComment(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"erordeleter",false);
		}
	}
	
//	xóa mềm 
	@GetMapping(value = "/soft_erase/{id}",produces =  {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> soft_erase(@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"soft_eraseSuccess",commentDAO.Soft_Erase(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",false);
		}
	}
	
	
//	nut like 
	@GetMapping(value = "/like/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> like(@PathVariable("id")Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"success",commentDAO.like(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"success",false);
		}
	}
	
	
	
//	not like
	@GetMapping(value = "/notlike/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> notlike(@PathVariable("id") Integer id) {
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"success",commentDAO.notlike(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Boolean>(MessageCode.ERROR,"error",false);
			
		}
	}
	
}
