package com.nt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.Binding.AddBlogBinding;
import com.nt.Entity.Comment;
import com.nt.Entity.Post;
import com.nt.Repository.PostRepo;
import com.nt.Services.PostServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostFunController {

	@Autowired
	private PostServiceImp postServiceImp;

	@Autowired
	private HttpSession session;

	@GetMapping("userDashboard")
	public String userDashboard(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		List<Post> userPost = postServiceImp.getBlogBaseOnUser(userId);
		model.addAttribute("userPosts", userPost);
		return "userDashboard";
	}

	@GetMapping("add-Blog")
	public String addBolg(AddBlogBinding binding, Model model) {
		model.addAttribute("add", binding);
		return "add-Blog";
	}

	@PostMapping("add-Blog")
	public String addBolgLoad(AddBlogBinding binding, Model model) {
		model.addAttribute("add", binding);
		System.out.println(binding);
		boolean status = postServiceImp.addPost(binding);
		if (status) {
			model.addAttribute("sucmsg", "Blog Added SuccessFully..!");
		} else {
			model.addAttribute("errmsg", "Blog Added Failed..! Please Try Again");
		}
		return "add-Blog";
	}

	@GetMapping("editpost")
	public String editpost(@RequestParam Long postId, Model model) {

		Post posts = postServiceImp.editPost(postId);
		model.addAttribute("postdata", posts);
		return "edit";
	}
	
	@PostMapping("edit")
	public String editAndsave(@ModelAttribute("postdata") Post post,Model model ) {
		
		boolean status=postServiceImp.editsave(post);
		if(status) {
		model.addAttribute("sucmsg","Post Updated Successfully..!" );
		}else {
			model.addAttribute("errmsg","Post Updated Failed..!" );
			
		}
		return "edit";
	}
	
	@GetMapping("deletepost")
	public String delete(@RequestParam Integer postId, Model model) {	
		boolean status=postServiceImp.delete(postId);
		if(status) {
			model.addAttribute("sucmsg", "Post Deleted Successfully..!");
		}else {
			model.addAttribute("errmsg", "Post Deleted Failed..!");
			
		}
		return "redirect:/userDashboard";
	}
	
	@GetMapping("comments")
	public String comments(Model model) {	
		List<Comment> comments=postServiceImp.comments();
		model.addAttribute("comments", comments);
		return "comments";
	}
	
	@GetMapping("deletecomment")
	public String deleteComment(@RequestParam("id")Integer Id,Model model) {
		boolean status=postServiceImp.commentdelete(Id);
		if(status) {
			model.addAttribute("sucmsg", "Comment Deleted SuccessFully...!");
		}else {
			model.addAttribute("sucmsg", "Comment Deleted Failed...!");		
		}
		return "redirect:/comments";
	}
	

}
