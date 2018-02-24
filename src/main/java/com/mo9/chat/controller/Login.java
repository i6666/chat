package com.mo9.chat.controller;

import com.mo9.chat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class Login {
	@Autowired
	LoginService loginservice;
	
	@RequestMapping("/loginvalidate")
	public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession){
		String picode=(String) httpSession.getAttribute("rand");
		if(username==null)
			return "login";
		String realpwd=loginservice.getpwdbyname(username);
		if(realpwd!=null&&pwd.equals(realpwd))
		{
			long uid=loginservice.getUidbyname(username);
			httpSession.setAttribute("username", username);
			httpSession.setAttribute("uid", uid);
			return "chatroom";
		}else
			return "fail";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession){
		httpSession.removeAttribute("username");
		httpSession.removeAttribute("uid");
		return "login";
	}
  }
