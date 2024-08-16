package com.nt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Post;

public interface PostRepo  extends JpaRepository<Post, Integer>{

	public Post findByPostId(Long postId);
	
	public List<Post> findByTitleContainingIgnoreCase(String search);
}
