package com.nt.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Binding.CommentBinding;
import com.nt.Entity.Comment;
import com.nt.Entity.Post;
import com.nt.Repository.CommentRepo;
import com.nt.Repository.PostRepo;

@Service
public class IndexServiceImp  implements IndexService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Override
	public List<Post> getAllpost() {		
		return postRepo.findAll();
	}
	
	@Override
	public Post postDetails(Integer postId) {
		Post post=postRepo.findById(postId).get();
		return post;
	}
	
	@Override
	public boolean submitComment(CommentBinding comment) {
		Comment commententity=new Comment();
		BeanUtils.copyProperties(comment, commententity);
		commentRepo.save(commententity);
		return true;
	}
	
	@Override
	public List<Post> search(String search) {		
		
		return (List<Post>) postRepo.findByTitleContainingIgnoreCase(search);
		
	}
	
}
