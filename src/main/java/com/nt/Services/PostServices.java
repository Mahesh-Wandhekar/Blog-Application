package com.nt.Services;

import java.util.List;

import com.nt.Binding.AddBlogBinding;
import com.nt.Entity.Comment;
import com.nt.Entity.Post;

public interface PostServices {

	
	public boolean addPost(AddBlogBinding binding);
	
	public List<Post> getBlogBaseOnUser(Integer UserId);
	
	public Post editPost(Long postId);
	
	public boolean editsave(Post post);
	
	public boolean delete(Integer postId);
	
	public List<Comment> comments();
	
	public boolean commentdelete(Integer id);
}
