package com.perkins.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
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
   
   @RequestMapping("/toTest2")
   public String toTest2(){
	   System.out.println(1112222222);
	   return "test2";
   }
   
   @ResponseBody
   @RequestMapping("/test2")
   public  String test2(@RequestParam Map<String,Object> param ){
	   System.out.println(222222222+","+param.get("content")+","+param.get("username"));
	   ObjectMapper obj=new ObjectMapper();
	   return "{id:12345,name:'jerry'}";
   }
   
   @ResponseBody
   @RequestMapping("/testRequest")
   public  String testRequest(@RequestParam Map<String,Object> param ){
	   System.out.println(222222222+","+param.get("content")+","+param.get("username"));
	   ObjectMapper obj=new ObjectMapper();
	   return "{id:12345,name:'jerry'}";
   }
}
