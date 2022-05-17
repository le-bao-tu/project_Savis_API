package com.example.savis.project_Savis_API.dao_impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.savis.project_Savis_API.dao.CommentDAO;
import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.entities.Account;
import com.example.savis.project_Savis_API.entities.Comment;
import com.example.savis.project_Savis_API.entities.List_Work;
import com.example.savis.project_Savis_API.entities.User_ListWork;
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
	public boolean InsertComment(Integer listWorkId, Integer accountId, Comment comment) {
		Comment rs = null;
		try {
			Optional<Account> account = accountRepository.findById(accountId);
			Optional<List_Work> listWork = list_WorkRepository.findById(listWorkId);
			if(listWork.isPresent()&& account.isPresent()){
				List_Work a = listWork.get();
				Account b = account.get();
				rs = new Comment(null,comment.getTitle(),comment.getStatus(),comment.getRole(),b,a);
			}
			commentRepository.save(rs);
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
	public boolean Soft_Erase(Integer id, Boolean role) {
		// TODO Auto-generated method stub
		try {
			Comment cmt = commentRepository.getById(id);
			cmt.setRole(role);
			commentRepository.save(cmt);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
}
