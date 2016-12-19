package com.inc.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inc.context.Context;
import com.inc.model.User;
import com.inc.service.UserService;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/go")
	public void login(HttpServletRequest request, HttpServletResponse resposne, String username, String password) throws IOException{
		
		User user = userService.getUser(username, password);
		if(user != null){
			//request.getSession().setAttribute("user", user);
			Context.userContext.set(user);
			resposne.sendRedirect("test/print");
		}else{
			
			//TODO
		}
	}
}
