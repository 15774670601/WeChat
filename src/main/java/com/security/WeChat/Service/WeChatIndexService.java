package com.security.WeChat.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.security.WeChat.bean.Classification;
import com.security.WeChat.bean.Company;

/**
 * 首页的业务接口
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public interface WeChatIndexService {
	
	/**
	 * 主页渲染业务层接口
	 * 渲染主页左导航栏
	 * @param request
	 * @return ArrayList<Classification>
	 * 
	 */
	public ArrayList<Classification> FillTheHomePage(HttpServletRequest request);
	
	/**
	 * 主页渲染业务层接口
	 * 渲染主页右窗体区
	 * @param request
	 * @return ArrayList<Company>
	 * 
	 */
	public ArrayList<Company> FillTheWindowPage(HttpServletRequest request,String ClassificationName);
	
}
