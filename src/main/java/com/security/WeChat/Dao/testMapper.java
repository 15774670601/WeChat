package com.security.WeChat.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.security.WeChat.bean.test;

/**
 * test实体的Mybatis接口
 * 
 * */

@Mapper
//@Repository
public interface testMapper {
	
	//查询所有
	//@Select("SELECT * FROM test")
	List<test> getTestList();
	
	//按照name查询age
	@Select("SELECT AGE FROM test WHERE name = #{name}")
	String getTestName(@Param("name") String name);
	
	@Select("SELECT * FROM TEST WHERE ID < 6")
	List<test> getTestTable();
	
}
