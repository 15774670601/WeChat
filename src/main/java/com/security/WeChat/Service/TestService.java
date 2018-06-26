package com.security.WeChat.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.security.WeChat.bean.test;

//@Service
@SuppressWarnings("all")
public interface TestService {
	public List<test> getTestList();
	
	public String getTestName(String name);
	
	public List<test> getTestTable();
}
