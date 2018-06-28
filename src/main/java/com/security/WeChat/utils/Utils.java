package com.security.WeChat.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.security.WeChat.bean.User;

public class Utils {
	
	private final String MD51 = "MDfrom字符";
	
	private final String MD52 = "#【GSKJ】#";
	
	private final String YES = "yes";
	
	/**
	 * 获取当前系统时间(java.utils)
	 * 格式:   yyyy-MM-dd HH:mm:ss
	 * @return Time
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
	
	
	/**
	 * 判断Http请求方式。
	 * @param request
	 * @return get请求返回true,其余皆返回post;
	 * 
	 */
	public boolean Get(HttpServletRequest request){
		if(request.getMethod().equals("GET")){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**利用加盐方式进行MD5加密
	 * 
     * @param password  待加密的字符串
     * @return  加密后的字符串
     */
    public String md5Password(String password) {
    	
    	//加盐
    	password = MD51 + password + MD52;
    	
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte b : result) {
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
    
    /**
     * 获取页数用方法
     * 
     */
  	public int getCount(double count) {  
  		count = count/5;
  		if((int)count == count){
  			return (int)count;
  		}else{
  			return (int)count+1;
  		}
      }  
  	
  	/**
  	 * 获取UUID加当前时间的组合
  	 * @return UUID
  	 */
  	public String getUUIDTime(){
		//生成原生UUID
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		//获取时间
		String time = getTime();
		//生成UUID字段值,并赋值
		String UUID = uuid+"-"+time;
		
		return UUID;
	}
  	
  	/**
  	 * 获取登录用户IP地址
  	 * 
  	 * @param request
  	 * @return ip
  	 */
	public static String getIp(HttpServletRequest request) {
	String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
	  	}
	  	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	  		ip = request.getRemoteAddr();
	  	}
	  	if (ip.equals("0:0:0:0:0:0:0:1")) {
	  		ip = "本地";
	  	}
	  	return ip;
  	}
	
	/**
	 * 在Session中存入一个令牌做标记
	 * loginState = yes
	 * 
	 */
	public void login_State(HttpServletRequest request,User user){
		//将用户存入Session
		HttpSession session = request.getSession();
		String SessionPhone = user.getPhone1()+"";
		session.setAttribute(SessionPhone, YES);
		session.setAttribute("loginState", YES);
		//设置Session的失效时间
		session.setMaxInactiveInterval(60 * 60);
		
		return;
	}
}
