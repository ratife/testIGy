package com.igy.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.igy.test.model.Comment;

public interface CommentRepository  extends CrudRepository<Comment, Long>   {
	
}
