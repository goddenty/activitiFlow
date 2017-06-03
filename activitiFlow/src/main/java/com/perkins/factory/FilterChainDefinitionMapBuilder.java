package com.perkins.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		map.put("/angular/*", "anon");
		map.put("/js/**", "anon");
		map.put("/shiro/toLogin", "anon");
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/user.jsp", "authc,roles[user]");
		map.put("/admin.jsp", "authc,roles[admin]");
		map.put("/list.jsp", "user");
		map.put("/list.jsp", "user");
		map.put("/**", "authc");
		map.put("/**", "anon");
		
		return map;
	}
	
}
