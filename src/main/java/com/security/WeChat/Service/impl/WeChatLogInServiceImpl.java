package com.security.WeChat.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.security.WeChat.Dao.UserMapper;
import com.security.WeChat.Service.WeChatLogInService;
import com.security.WeChat.bean.User;
import com.security.WeChat.utils.FinalUtils;


/**
 * 登录注册的业务层实现
 * @author GSKJ
 *
 */
@Service
@Component
public class WeChatLogInServiceImpl extends FinalUtils implements WeChatLogInService {
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 注册业务层方法实现-Master
	 * 
	 */
	@Override
	public Boolean Register(User user) {
		
		if(user == null){
			
			return false;
		}
		
		try {
			//获取UUID字段值
			String uuidTime = utils.getUUIDTime();
			//进行赋值
			user.setUUID(uuidTime);
			//设置activation字段(激活状态)
			user.setActivation(SUBMISSION);
			//设置identity字段(主从关系)
			user.setIdentity(Master);
			//调用Mybatis接口
			userMapper.Register(user);
			
			//SlaveRegister(user);
			
			return true;
			
		} catch (Exception e) {
			
			logger.error("ERROR:   "+e);
			
			return false;
		}

	}
	
	/**
	 * Slave用户注册方法
	 * @param user
	 * @return
	 */
	@Override
	public Boolean SlaveRegister(User user) {
		
		//获取UUID字段值
		String uuidTime = utils.getUUIDTime();
		
		//判断是否存在第一个slave
		if(user.getPhone2() != null || user.getPhone2() != 0){
			user.setUUID(uuidTime);
			//设置activation字段(激活状态)
			user.setActivation(SUBMISSION);
			//设置identity字段(主从关系)
			user.setIdentity(Slave);
			//设置phone
			user.setPhone1(user.getPhone2());
			//设置初始密码为admin
			user.setPassword(utils.md5Password("admin"));
			//调用Mybatis接口
			userMapper.Register(user);
			
			//测试
			logger.info("slave1");
		}
		
		//判断是否存在第二个slave
		if(user.getPhone3() != null || user.getPhone3() != 0){
			user.setUUID(uuidTime);
			//设置activation字段(激活状态)
			user.setActivation(SUBMISSION);
			//设置identity字段(主从关系)
			user.setIdentity(Slave);
			//设置phone
			user.setPhone1(user.getPhone3());
			//设置初始密码为admin
			user.setPassword(utils.md5Password("admin"));
			//调用Mybatis接口
			userMapper.Register(user);
			
			//测试
			logger.info("slave2");
		}
		
		return null;
	}
	
	/**
	 * 登录业务层方法实现
	 * 
	 */
	@Override
	public Boolean LogIn(User user) {
		
		//非空校验
		if(user == null){
			logger.error("登录对象为: NULL");
			
			return false;
		}else if(user.getPhone1() == null || user.getPhone1() == 0){
			logger.error("登录对象用户名为: NULL");
			
			return false;
		}else if(user.getPassword() == null){
			logger.error("登录对象密码为: NULL");
			
			return false;
		}
		
		//密码加密处理
		String md5Password = utils.md5Password(user.getPassword());	
		user.setPassword(md5Password);
		
		//调用Mybatis登录接口
		try {
			userMapper.LogIn(user);
			return true;
			
		} catch (Exception e) {
			logger.error("ERROR:   "+e);
			return false;
		}
		
	}

}
