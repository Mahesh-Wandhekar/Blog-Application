package com.nt.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Binding.AddBlogBinding;
import com.nt.Entity.Comment;
import com.nt.Entity.Post;
import com.nt.Entity.User;
import com.nt.Repository.CommentRepo;
import com.nt.Repository.PostRepo;
import com.nt.Repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class PostServiceImp implements PostServices {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CommentRepo commentRepo;

	@Override
	public boolean addPost(AddBlogBinding binding) {
		Integer userId = (Integer) session.getAttribute("userId");
		Post post = new Post();
		BeanUtils.copyProperties(binding, post);
		Optional<User> user = userrepo.findById(userId);
		if (user.isPresent()) {
			User userData = user.get();
			post.setUser(userData);
			postRepo.save(post);
			return true;
		}
		return false;
	}

	@Override
	public List<Post> getBlogBaseOnUser(Integer UserId) {

		Optional<User> user = userrepo.findById(UserId);
		if (user.isPresent()) {

			User userdtl = user.get();

			List<Post> userPosts = userdtl.getPost();

			return userPosts;
		}

		return null;
	}
	
	@Override
	public Post editPost(Long postId) {
		
		Post posts=postRepo.findByPostId(postId);
		
		return posts;
		
	}
	
	@Override
	public boolean editsave(Post post) {	
		Integer userId=(Integer)session.getAttribute("userId");		
		User user=userrepo.findById(userId).get();
		post.setUser(user);
		postRepo.save(post);
		return true;
	}
	
	@Override
	public boolean delete(Integer postId) {
		postRepo.deleteById(postId);
		return true;
	}
	
	@Override
	public List<Comment> comments() {
		List<Comment> comments=commentRepo.findAll();
		return comments;	
	}
	
	
	@Override
	public boolean commentdelete(Integer id) {
		commentRepo.deleteById(id);
		return true;
	}

}
