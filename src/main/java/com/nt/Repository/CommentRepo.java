package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Comment;

public interface CommentRepo  extends JpaRepository<Comment, Integer>{

}
