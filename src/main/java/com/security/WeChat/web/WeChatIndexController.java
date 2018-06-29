package com.security.WeChat.web;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.WeChat.Service.WeChatIndexService;
import com.security.WeChat.Service.impl.WeChatIndexServiceImpl;
import com.security.WeChat.bean.Classification;
import com.security.WeChat.bean.Company;
import com.security.WeChat.utils.FinalUtils;

/**
 * 首页的Controller层
 * @author GSKJ
 *
 */
@Slf4j
@Controller
@SpringBootApplication
@SuppressWarnings("all")
@MapperScan("com.security.WeChat.Dao")
public class WeChatIndexController extends FinalUtils{
	
	@Autowired
	WeChatIndexServiceImpl weChatIndexServiceImpl;
	
	
	/**
	 * 首页填充渲染
	 * 
	 */
	@GetMapping("/index")
	public String FillTheHomePage(HttpServletRequest request,Map<String, Object> model){
		logger.info("/index : 开始进行首页渲染..");
		
		//左侧边栏集合获取:
		ArrayList<Classification> leftList = weChatIndexServiceImpl.FillTheHomePage(request);
		
		if(leftList == null || leftList.size() == 0){
			//返回错误页面(数据库无数据)
			logger.error("请在分类表中激活分类..");
			return "HttpError/404";
		}
		
		//rightWindow 右窗体集合获取:
		ArrayList<Company> listWindow = weChatIndexServiceImpl.FillTheWindowPage(request, "休闲娱乐");
		
		if(listWindow == null || leftList.size() == 0){
			//返回错误页面(数据库无数据)
			logger.error("请在公司/商铺表中激活分类..");
			return "HttpError/404";
		}
		
		this.indexModel(request, model, leftList, listWindow);
		
		logger.info("/index : 完成首页渲染..");
		return "index";
	}
	
	
	
	/**
	 * 向首页的Freemaker返回初始化用的模型
	 * @param request
	 * @param model
	 */
	public void indexModel(HttpServletRequest request,Map<String, Object> model,ArrayList<Classification> leftList,ArrayList<Company> listWindow){
		
		//左侧边栏
		//leftListNumber,左侧边栏数量
		model.put("leftListNumber", leftList.size());
		//左侧边栏分类
		for (int i = 1; i < 9; i++) {
			model.put("leftList"+i, leftList.get(i-1).getName());
		}
		//右窗体Model返回
		for (int i = 1; i < listWindow.size(); i++) {
			model.put("listWindowName"+i, listWindow.get(i-1).getName());
			model.put("listWindowImg"+i, listWindow.get(i-1).getImg());
			model.put("listWindowAddress"+i, listWindow.get(i-1).getAddress());
		}
		
	}
	
}
