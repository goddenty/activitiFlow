package com.perkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perkins.service.IMailSendRecordService;

@Controller
@RequestMapping("/angular")
public class TestController {

	@Autowired
	private IMailSendRecordService mailRecordService;

	@RequestMapping("/test1")
	public String test1() {
		System.out.println(111111111);
		return "test1";
	}

	@RequestMapping("toTest2")
	public String toTest2() {
		return "test2";
	}

	@ResponseBody
	@RequestMapping("/test2")
	public String test2(@RequestParam String username) throws JsonProcessingException {
		System.out.println("222222222 " + username);
		// Map<String, String> info = new HashMap<String, String>();
		// info.put("id", "username");
		// info.put("name", "jerry");
		User user = new User("username", "jerry");
		ObjectMapper om = new ObjectMapper();
		String str=om.writeValueAsString(user);

		return str;
		// return ;
	}
}

class User {
	private String username;
	private String id;

	public User(String username, String id) {
		this.username = username;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
