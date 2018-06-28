package com.security.WeChat.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.security.WeChat.bean.User;

/**
 * User表的Mapper接口
 * @author GSKJ
 *
 */
@Mapper
public interface UserMapper {
	
	/**
	 * INSERT 语句 
	 * 注册接口方法
	 * @param user
	 */
	@Insert("insert into \"User\" values (#{user.UUID,jdbcType=VARCHAR},#{user.name,jdbcType=VARCHAR},#{user.phone1,jdbcType=INTEGER},#{user.password,jdbcType=INTEGER},#{user.activation,jdbcType=INTEGER},#{user.identity,jdbcType=INTEGER},#{user.company,jdbcType=INTEGER})")
	public void Register(@Param("user") User user);
	
	
	/**
	 * SELECT 语句 
	 * 登录接口方法
	 * @param user
	 */
	@Select("select * from \"User\" where \"phone\"=#{user.phone1,jdbcType=INTEGER} and \"password\"=#{user.password,jdbcType=INTEGER}")
	public String LogIn(@Param("user") User user);
	
	
	
}
