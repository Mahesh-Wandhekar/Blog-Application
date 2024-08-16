package com.nt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.Binding.CommentBinding;
import com.nt.Entity.Comment;
import com.nt.Entity.Post;
import com.nt.Services.IndexService;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Post> allPost = indexService.getAllpost();
		
		model.addAttribute("userspost", allPost);		
		return "index";
	}
	
	@GetMapping("logout")
	public String logout(Model mode) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("post-details")
	public String postdetails(@RequestParam(value = "postId", required = false) Integer postId, CommentBinding comment,  Model model) {
		
		if(postId!=null) {
			Post post = indexService.postDetails(postId);
			model.addAttribute("postdetails", post);		    
	}
	    
	    model.addAttribute("comment",comment);
	    return "post-details";
	}
	
	@PostMapping("commentsend")
	public String commentsend(@ModelAttribute("comment") CommentBinding comment,Model model) {	
		indexService.submitComment(comment);	
		return "redirect:/post-details";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value = "search", defaultValue = "")  String search,Model model) {
		
		System.out.println(search);
		List<Post> result=indexService.search(search);		
		model.addAttribute("search", result);
		 model.addAttribute("searchTitle", search);
		
		return "index1";
	}
	
	
	
	
}
