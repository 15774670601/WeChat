package com.security.WeChat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.security.WeChat.utils.FinalUtils;

/**
 * Spring Boot 全局错误映射类
 * 
 * */
@Controller
@SuppressWarnings("all")
public class WeChatErrorController extends FinalUtils implements ErrorController{
	
	private static final String ERROR_PATH = "/error";  
	   
	//@RequestMapping(value=ERROR_PATH)
	@GetMapping(value=ERROR_PATH)
	public String handleError(){
		
		logger.error("Http请求可能发生异常...");
		return "HttpError/404";
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
