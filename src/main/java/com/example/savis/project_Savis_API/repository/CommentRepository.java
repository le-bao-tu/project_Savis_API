package com.example.savis.project_Savis_API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savis.project_Savis_API.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>  {
	Page<Comment> findByStatus(Pageable pageable, Boolean status);
}
