package com.security.WeChat.Service;

import com.security.WeChat.bean.User;

/**
 * 登录注册的业务接口
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public interface WeChatLogInService {
	
	/**
	 * Master注册
	 * @return 布尔
	 */
	public Boolean Register(User user);
	
	/**
	 * Slave注册
	 * @return 布尔
	 */
	public Boolean SlaveRegister(User user);
	
	/**
	 * 登录
	 * @return 布尔
	 */
	public Boolean LogIn(User user);
}
