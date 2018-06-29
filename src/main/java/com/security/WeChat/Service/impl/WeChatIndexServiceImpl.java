package com.security.WeChat.Service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

import com.security.WeChat.Dao.ClassificationMapper;
import com.security.WeChat.Dao.CompanyMapper;
import com.security.WeChat.Service.WeChatIndexService;
import com.security.WeChat.bean.Classification;
import com.security.WeChat.bean.Company;
import com.security.WeChat.utils.FinalUtils;

/**
 * 首页的业务层实现
 * @author GSKJ
 *
 */
@Service
@Component
public class WeChatIndexServiceImpl extends FinalUtils implements WeChatIndexService {
	
	@Autowired
	ClassificationMapper classificationMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	/**
	 * 首页渲染业务层实现
	 * 
	 */
	@Override
	public ArrayList<Classification> FillTheHomePage(HttpServletRequest request) {
	
		ArrayList<Classification> fillTheHomePage = classificationMapper.FillTheHomePage();
		
		//左侧边栏
		try {
			if(fillTheHomePage == null){
				logger.error("/index : 数据库获取分类表结果为空..");
				
				return null;
			}else{
				
				//权重筛选与排序
				int temp = 0;
		        int size = fillTheHomePage.size();
		        Classification classifications = new Classification();
		        
		        for(int i = 0 ; i < size-1; i ++)
		        {
			        for(int j = 0 ;j < size-1-i ; j++)
			        {
			            if(fillTheHomePage.get(j).getWeight() < fillTheHomePage.get(j+1).getWeight())  //交换两数位置
			            {
				            classifications = fillTheHomePage.get(j);
				            fillTheHomePage.set(j, fillTheHomePage.get(j+1));
				            fillTheHomePage.set(j+1, classifications);
			            }
			        }
		        }
		        
				return fillTheHomePage;
			}
			
		} catch (Exception e) {
			logger.error("/index : 业务层左侧边栏出现异常..  \r\n"+e);
			
			return null;
		}
		
		
	}
	
	
	
	/**
	 * 主页渲染业务层接口
	 * 渲染主页右窗体区
	 * @param request
	 * @return ArrayList<Company>
	 * 
	 */
	@Override
	public ArrayList<Company> FillTheWindowPage(HttpServletRequest request,String ClassificationName) {
		
		ArrayList<Company> fillTheHomePage = companyMapper.FillTheHomePage(ClassificationName);
		
		return fillTheHomePage;
	}

}





















