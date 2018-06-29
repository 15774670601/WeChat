package com.security.WeChat.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.WeChat.Service.WeChatLogInService;
import com.security.WeChat.Service.impl.WeChatLogInServiceImpl;
import com.security.WeChat.bean.User;
import com.security.WeChat.utils.FinalUtils;

@Slf4j
@Controller	//使用模板引擎需要使用@Controller注解
@SpringBootApplication
@SuppressWarnings("all")
@MapperScan("com.security.WeChat.Dao")
public class WeChatLogInController extends FinalUtils {
	
	@Autowired
	WeChatLogInService weChatLogInService;
	
	@Autowired
	WeChatLogInServiceImpl weChatLogInServiceImpl;
	
	@Autowired
	User user;
	
	/**
	 * 注册的Controller层
	 * @param request
	 * @param model
	 * @param repassword 确认密码
	 * @return 登录界面
	 * 
	 */
	@GetMapping("/register")
	@SuppressWarnings("all")
	public String Register(HttpServletRequest request,Map<String, Object> model,User users,String repassword){
		
		if(utils.Get(request)){
			
			return "Regist";
		}else{
			
			//密码校验
			if(!users.getPassword().equals(repassword)){
				logger.error("/register : 密码与确认密码不一致..");
				
				return "Regist";
			}
			
			//记录IP:
			String ip = utils.getIp(request);
			logger.info("/register: IP:  "+ip);
			
			//调用业务层
			logger.info("/register");
			
			try {
				weChatLogInServiceImpl.Register(users);
				
			} catch (Exception e) {
				logger.error("/register: ERROR:  "+e);
				
			}
			
			logger.info("/register: YES");
			
			return "Login";
		}
	}
	
	
	
	/**
	 * 登录的Controller层
	 * @param request
	 * @param model
	 * @return 项目首页
	 * 
	 */
	@GetMapping("/login")
	@SuppressWarnings("all")
	public String LogIn(HttpServletRequest request,Map<String, Object> model,User users){
		
		if(utils.Get(request)){
			
			return "Login";
		}else{
			
			//模拟登录效果
			users.setPhone1(130);
			users.setPassword("admin");
	
			//记录IP:
			String ip = utils.getIp(request);
			logger.info("IP:    "+ip);
			
			//跳转业务层
			logger.info("/login");
			try {
				weChatLogInServiceImpl.LogIn(users);
				utils.login_State(request,users);
				
				logger.info(utils.getTime()+":  "+users.getPhone1()+"登入到系统..");
				
			} catch (Exception e) {
				logger.error("/login: ERROR:  "+e);
				
			}
			
			logger.info("/login: YES");
			
			return "index";
		}
	}
	
	
	
	/**
	 * 简单的测试方法
	 * @param request
	 * @param model
	 * @param users
	 * @return
	 */
	@GetMapping("/demo")
	@SuppressWarnings("all")
	public String Demo(HttpServletRequest request,Map<String, Object> model,User users){
		
		//模拟登录效果
		users.setPhone1(130);
		users.setPassword("admin");

		//记录IP:
		String ip = utils.getIp(request);
		logger.info("IP:    "+ip);
		
		//跳转业务层
		logger.info("/login");
		try {
			weChatLogInServiceImpl.LogIn(users);
			utils.login_State(request,users);
			
			logger.info(utils.getTime()+":  "+users.getPhone1()+"登入到系统..");
			
		} catch (Exception e) {
			logger.error("/login: ERROR:  "+e);
			
		}
		
		logger.info("/login: YES");
		
		return "index";
	}
	
}
