package com.example.savis.project_Savis_API.dao_impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.Model.Commnet_ResourceModel;
import com.example.savis.project_Savis_API.dao.CommentDAO;
import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.entities.Account;
import com.example.savis.project_Savis_API.entities.Comment;
import com.example.savis.project_Savis_API.entities.List_Work;
import com.example.savis.project_Savis_API.repository.AccountRepository;
import com.example.savis.project_Savis_API.repository.CommentRepository;
import com.example.savis.project_Savis_API.repository.List_WorkRepository;
import com.example.savis.project_Savis_API.util.commentRequest;

@Service 
public class CommentDAO_impl implements CommentDAO {

	@Autowired CommentRepository commentRepository;
	@Autowired List_WorkRepository list_WorkRepository;
	@Autowired AccountRepository accountRepository;
	
	
	@Override
	public Page<Comment> getComment(Pageable pageable,Boolean role) {
		try {
			return commentRepository.findByRole(pageable, role);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	
	}
	
	@Override
	public ResonpeBodyDto getCommentCustom(commentRequest request) {
		ResonpeBodyDto rs = new ResonpeBodyDto();
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
		Page<Comment> lst = commentRepository.findAll(pageable);
		if(lst != null) {
			rs.setMessage("get Data Success");
			rs.setMessageCode("200");
			rs.setPageNumber(lst.getNumberOfElements());
			rs.setData(lst.getContent());
		}else {
			rs.setMessage("get data failure");
			rs.setMessageCode("400");
			rs.setPageNumber(lst.getNumberOfElements());
			rs.setData(new Comment());
		}
		return rs;
	}
	
	
	@Override
	@Transactional
	public boolean InsertComment(Commnet_ResourceModel comment) {
	
		try {
			
			Comment cmt = new Comment();
			cmt.setId(comment.id);
			cmt.setTitle(comment.title);
			cmt.setStatus(comment.status);
			cmt.setRole(comment.role);
			cmt.setList_Work(list_WorkRepository.findById(Integer.valueOf(comment.getList_Work())).get());
			cmt.setAccount(accountRepository.findById(Integer.valueOf(comment.getAccount())).get());
			commentRepository.save(cmt);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean UpdateComment(String titel, Integer id) {
		try {
			Comment comment = commentRepository.getById(id);
			comment.setTitle(titel);
			commentRepository.save(comment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} 
	}
	@Override
	public boolean DeleteComment(Integer commentId) {
		try {
			commentRepository.deleteById(commentId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean Soft_Erase(Integer id) {
		// TODO Auto-generated method stub
		try {
			
			Optional<Comment> cmt = commentRepository.findById(id);
			if(cmt.isPresent() && cmt.get().getRole() != false) {
				cmt.get().setRole(false);;
			}else {
				System.err.println("error");
			}
			
			commentRepository.save(cmt.get());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean like(Integer id) {
		// TODO Auto-generated method stub
		try {
			Optional<Comment> cmt = commentRepository.findById(id);
			if(cmt.isPresent()) {
				cmt.get().setStatus(true);
			}else {
				System.err.println("error");
			}
			commentRepository.save(cmt.get());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean notlike(Integer id) {
		// TODO Auto-generated method stub
		try {
			Optional<Comment> cmt = commentRepository.findById(id);
			if(cmt.isPresent()) {
				cmt.get().setStatus(false);
			}else {
				System.err.println("error");
			}
			commentRepository.save(cmt.get());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
