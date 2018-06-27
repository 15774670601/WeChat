package com.security.WeChat;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.security.WeChat.Service.TestServiceImpl;
import com.security.WeChat.bean.test;
import com.security.WeChat.utils.Utils;


//@RestController //该注解表示返回的内容都是HTTP Content不会被模版引擎处理
@Slf4j
@Controller	//使用模板引擎需要使用@Controller注解
@SpringBootApplication
@MapperScan("com.security.WeChat.Dao")
public class WeChatApplication {
	
	@Autowired  
    JdbcTemplate jdbc;
	
	@Autowired
	TestServiceImpl testServiceImpl;
	
	@Autowired
	test UserT;
	
	//工具类
	Utils utils = new Utils();
	
	//日志
	private final static Logger logger = LoggerFactory.getLogger(WeChatApplication.class);
	
	public static void main(String[] args) {
		logger.info("SpringBoot程序正在启动...");
		//SpringBoot框架Run方法
		SpringApplication.run(WeChatApplication.class, args);
		logger.info("SpringBoot程序完成启动...");
	}
	
	
	//@RequestMapping("/")
	@GetMapping("/")
	@SuppressWarnings("all")
	public String getHello(HttpServletRequest request,Map<String, Object> model){
		
		utils.md5Password("123");
		
		//判断请求方式
		if(utils.Get(request)){
			System.out.println("GET请求..");
			//返回主页
			List<test> testTable = testServiceImpl.getTestTable();
			System.out.println("testTable:  "+testTable);
			model.put("num", 0);
			model.put("list", testTable);
			model.put("demo", "0601@163.com");
			
		}else{
			System.out.println("POST请求..");
			ArrayList listId = new ArrayList();
			//调用数据库
			List<test> testList = testServiceImpl.getTestList();
			//条数
			double count;
			for (count = 1; count <= 5; count++) {
				//listId
			}
			//获取页数
			int num = utils.getCount(count);
			//填充视图
			model.put("num", num);
			model.put("list",testList);
			model.put("demo", "0601@163.com");
		}
		return "index";
	}
	
	
	/**
	 * 
	 * 手机号登录
	 */
	public String LogIn(){
		
		return null;
	}
	
	/**
	 * 
	 * 项目注册
	 */
	public String Register(){
		
		return null;
	}
	
}