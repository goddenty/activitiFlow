package com.perkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perkins.service.IMailSendRecordService;

@Controller
@RequestMapping("/angular")
public class TestController {
	
	@Autowired
	private IMailSendRecordService mailRecordService;
	
   @RequestMapping("/test1")
   public String test1(){
	   System.out.println(111111111);
	   return "test1";
   }
   
   @ResponseBody
   @RequestMapping("/test2")
   public  String test2(){
	   System.out.println(222222222);
	   return "{'id':12345,'name':'jerry'}";
   }
}
