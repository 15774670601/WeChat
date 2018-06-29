package com.security.WeChat.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.security.WeChat.bean.Classification;

/**
 * Classification,分类表的Mapper接口
 * @author GSKJ
 *
 */
@Mapper
public interface ClassificationMapper {
	
	/**
	 * SELECT 语句 
	 * 首页渲染接口方法
	 * 
	 */
	@Select("SELECT * FROM \"Classification\" where \"activation\" = 1")
	public ArrayList<Classification> FillTheHomePage();
	
}
