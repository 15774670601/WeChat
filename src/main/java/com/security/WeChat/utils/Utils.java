package com.security.WeChat.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	
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
    	password = "MDfrom字符" + password + "【GSKJ】{‘#";
    	
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            
            // 标准的md5加密后的结果
            System.out.println("密码"+buffer.toString());
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
}
