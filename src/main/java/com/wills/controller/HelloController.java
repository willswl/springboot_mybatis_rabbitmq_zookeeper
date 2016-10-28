package com.wills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wills.model.User;
import com.wills.service.Sender;
import com.wills.service.UserService;

@Controller
public class HelloController {
	@Autowired
	private Sender sender;
	

    @Autowired
    private UserService userService;
	
    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        sender.sendMsg("wills messages");
        return "hello";
    }
    
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam(value="name") String name, Model model){
    	User user = new User();
    	user = userService.updateUserInfo(name);
		
        model.addAttribute("name", user.getName());
        return "hello";
    }
    
}
