package com.demo.demo_proj.controller;

import java.util.List;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.demo_proj.entity.User;
import com.demo.demo_proj.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		Iterable<User> userList = userRepository.findAll();		
		model.addAttribute("userList", userList);
		return "index";
	}
	
	@GetMapping("/chat")
	public String chat() {
		return "chat";
	}
	
	@GetMapping("/user/create")
	 public String newUser(Model model) {
		    model.addAttribute("user",new User());
	        return "user";
	 }
	
	 @PostMapping("/user/create")
	 public ModelAndView createUser(@ModelAttribute User user) {
		   userRepository.save(user);
		   return new ModelAndView("redirect:/");
	 }
	
	@GetMapping(value="/user/update/{userRef}")
	public String updateUser(Model model,@PathVariable("userRef") Long userRef) {
		Object user = userRepository.findById(userRef);
		model.addAttribute("user",user);
		return "user";
	}
	
	@PostMapping("/user/update")
	 public ModelAndView updateUser(@ModelAttribute User user) {
		   userRepository.save(user);
		   return new ModelAndView("redirect:/");
	 }
	
	@GetMapping(value="/user/delete/{userRef}")
	public ModelAndView delteUser(Model model,@PathVariable Long userRef) {
		System.out.println(userRef);
		userRepository.deleteById(userRef);
		return new ModelAndView("redirect:/");
	}
	
	
	/*@GetMapping("/user/list")
	public String userList(Model model) {
		Iterable<User> userList = userRepository.findAll();
		for (User user : userList) {
			System.out.println(user.getName());
		}
		model.addAttribute("userList", userList);
		return "userlist";
	} */

}
