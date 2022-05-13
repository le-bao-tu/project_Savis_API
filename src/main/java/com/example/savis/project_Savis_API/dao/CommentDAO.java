package com.example.savis.project_Savis_API.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.savis.project_Savis_API.dto.ResonpeBodyDto;
import com.example.savis.project_Savis_API.dto.commentRequest;
import com.example.savis.project_Savis_API.entities.Comment;

public interface CommentDAO {
	public Page<Comment> getComment(Pageable pageable,Boolean status);
	
	ResonpeBodyDto getCommentCustom(commentRequest request);
	
	public boolean InsertComment(Integer listWorkId,Integer accountId,Comment comment);
	public boolean UpdateComment(String titel ,Integer id);
	public boolean DeleteComment(Integer commentId);
}
