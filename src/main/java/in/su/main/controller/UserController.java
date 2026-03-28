package in.su.main.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.su.main.entities.User;
import in.su.main.repository.UserRepo;

@Controller
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@GetMapping("/")
	public String gotoHomePage(Model model) {
		model.addAttribute("postList",repo.findAll());
		return "index";
	}
	
	@GetMapping("/newPost")
	public String addPost(Model model) {
		model.addAttribute("post",new User());
		return "NewPost";
	}
	@PostMapping("/save")
	public String savePost(@ModelAttribute("post") User user) {
		repo.save(user);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editPost(@PathVariable Long id, Model model) {
		User user=repo.findById(id).orElseThrow(()->new RuntimeException("not found"));
		model.addAttribute("post",user);
		model.addAttribute("id",id);
		return "EditPostPage";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("post") User user,@ModelAttribute("id") Long id) {
		repo.save(user);
		repo.deleteById(id);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable long id) {
		repo.deleteById(id);
		return "redirect:/";
	}
}
