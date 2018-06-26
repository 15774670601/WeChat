package com.security.WeChat.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.security.WeChat.Dao.testMapper;
import com.security.WeChat.bean.test;

@Service
@Component
public class TestServiceImpl implements TestService{
	
	/**
	 * 查询所有
	 * 
	 * */
	@Autowired  //按照类型注入
	//@Resource  //按照名称注入
	private testMapper testMappers;
	
	//查询所有
	@Override
	public List<test> getTestList(){
		System.out.println("service:  "+testMappers.getTestList());
		
		return testMappers.getTestList();
	}
	
	//按照Name查询Age
	@Override
	public String getTestName(String name) {
		System.out.println("按照NAME查询结果：    "+ testMappers.getTestName(name));
		
		return testMappers.getTestName(name);
	}
	
	/**
	 * 主页分页
	 */
	@Override
	public List<test> getTestTable() {
		
		return testMappers.getTestTable();
	}
	

}