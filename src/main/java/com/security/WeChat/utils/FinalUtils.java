package com.security.WeChat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.security.WeChat.WeChatApplication;
import com.security.WeChat.Service.TestServiceImpl;

//通过类的整合工具类
@SuppressWarnings("all")
public class FinalUtils {
	
	/**
	 * 常量: 账户未激活
	 */
	public final int NOT_ACTIVE = 0;
	
	/**
	 * 常量: 账户正在激活
	 */
	public final int SUBMISSION = 1;
	
	/**
	 * 常量: 账户已激活
	 */
	public final int ALREADY_ACTIVATED = 2;
	
	/**
	 * 常量: 返回master
	 */
	public final String Master = "master";
	
	/**
	 * 常量: 返回slave
	 */
	public final String Slave = "slave";
	
	/**
	 * 常量: 分类未激活
	 */
	public final int CLASSIFICATION_NOT_ACTIVE = 0;
	
	/**
	 * 常量: 分类已激活
	 */
	public final int CLASSIFICATION_ALREADY_ACTIVATED = 1;

	
	/**
	 * JdbcTemplate
	 */
	@Autowired  
	public JdbcTemplate jdbc;
	
	/**
	 * TestServiceImpl
	 */
	@Autowired
	public TestServiceImpl testServiceImpl;
	
	/**
	 * logback日志
	 */
	public final static Logger logger = LoggerFactory.getLogger(WeChatApplication.class);
	
	/**
	 * 简单的函数工具类
	 */
	public final Utils utils = new Utils();
}
