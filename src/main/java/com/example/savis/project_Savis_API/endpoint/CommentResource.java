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

import com.example.savis.project_Savis_API.dao.CommentDAO;
import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.dto.ServiceResponse;
import com.example.savis.project_Savis_API.dto.commentRequest;
import com.example.savis.project_Savis_API.dto.userRequest;
import com.example.savis.project_Savis_API.entities.Comment;
import com.example.savis.project_Savis_API.util.MessageCode;

@RequestMapping("api")
@RestController
public class CommentResource {
	@Autowired CommentDAO commentDAO;
	
	@GetMapping(value = "/comment_List",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Page<Comment>> getComment(Pageable pageable,@RequestParam("status")Boolean status){
		try {
			return new ServiceResponse<Page<Comment>>(MessageCode.SUCCESS,"Seccess",commentDAO.getComment(pageable, status));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ServiceResponse<Page<Comment>>(MessageCode.SUCCESS,"Seccess",null);
		}
	}
	@PostMapping(value = "/insertComment/{list_WorkId}and/{accountId}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ServiceResponse<Boolean> insertComment(@PathVariable("list_WorkId")Integer listWorkId,@PathVariable("accountId")Integer accountId,@RequestBody Comment comment){
		try {
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"success",commentDAO.InsertComment(listWorkId, accountId, comment));
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
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS,"errorUpdate",false);
		}
	}
	
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
	
	@PostMapping(value ="/getComment")
	public ResonpeBodyDto getUser(@RequestBody commentRequest request) {
//		ResonpeBodyDto rs = new ResonpeBodyDto<>();
		return commentDAO.getCommentCustom(request);
	}
}
