package com.nt.Services;

import java.util.List;

import com.nt.Binding.CommentBinding;
import com.nt.Entity.Comment;
import com.nt.Entity.Post;

public interface IndexService {

	
	public List<Post> getAllpost();
	
	public Post postDetails(Integer postId);
	
	public boolean submitComment(CommentBinding comment);
	
	public List<Post> search(String search);
}
