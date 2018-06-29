package com.security.WeChat.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.security.WeChat.bean.Classification;
import com.security.WeChat.bean.Company;

/**
 * Company,公司/商铺表的Mapper接口
 * @author GSKJ
 *
 */
@Mapper
public interface CompanyMapper {
	
	/**
	 * SELECT 语句 
	 * 首页渲染接口方法
	 * 按照分类名称查询到前2条数据
	 * 
	 */
	@Select("SELECT * FROM \"Classification\" cl left join \"Company\" co on (co.\"classificationUUID\" = cl.UUID) where co.\"activation\" = 1 and cl.\"name\"= #{classificationName,jdbcType=VARCHAR} and rownum <3")
	public ArrayList<Company> FillTheHomePage(@Param("classificationName") String classificationName);
}
