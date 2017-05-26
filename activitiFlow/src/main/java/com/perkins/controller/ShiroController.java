package com.perkins.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perkins.service.IShiroService;

@Controller
@RequestMapping("/shiro")
public class ShiroController {
	@Autowired
	private IShiroService shiroService;
	
	@RequestMapping("/testShiroAnnotation")
	public String testShiroAnnotation(HttpSession session){
		session.setAttribute("key", "value12345");
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		System.out.println("123344455");
		return "login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println("30380840380438");
		if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            try {
            	System.out.println("1. " + token.hashCode());
                currentUser.login(token);
            } 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("认证异常: " + ae.getMessage());
            }
        }
		
		return "redirect:/list.jsp";
	}
}
