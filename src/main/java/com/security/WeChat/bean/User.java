package com.security.WeChat.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//这个注解用于在配置文件中进行注入。
@ConfigurationProperties(prefix="Test") 
//这个注解是读取指定的配置文件。
@PropertySource(value={"classpath:test.properties"})
/**
 * User表的Bean,用于封装用户最基本的个人信息
 * @author GSKJ
 *
 */
public class User {
	
	/**
	 * 由Rownum伪列充当User表的ID主键
	 */
	private int rownum;
	
	/**
	 * 标识身份的id串，它应该由初始化时随机的UUID以及时间戳组层成。
	 */
	@Value("caolin")
	private String UUID ;
	
	/**
	 * 商家商铺或公司名称
	 */
	@Value("")
	private String name;
	
	/**
	 * 商家手机及登录账户1
	 */
	@Value("110")
	private Integer phone1;
	
	/**
	 * 商家手机及登录账户2
	 */
	@Value("120")
	private Integer phone2;
	
	/**
	 * 商家手机及登录账户3
	 */
	@Value("130")
	private Integer phone3;
	
	/**
	 * 已进行加密的登录秘钥
	 */
	@Value("1234567")
	private String password;
	
	/**
	 * 认证激活情况:
	 * 	0 - 未激活
	 *  1 - 正在认证
	 *  2 - 已激活
	 */
	private Integer activation;
	
	/**
	 * 用户身份,一个master对应2个slave;
	 * master为主，slave为辅
	 */
	private String identity;
	
	/**
	 * 商家注册的公司/商铺表的主键
	 */
	private String company;
	
	
	
	//GetSet方法区
	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone1() {
		return phone1;
	}

	public Integer getPhone2() {
		return phone2;
	}

	public void setPhone2(Integer phone2) {
		this.phone2 = phone2;
	}

	public Integer getPhone3() {
		return phone3;
	}

	public void setPhone3(Integer phone3) {
		this.phone3 = phone3;
	}

	public void setPhone1(Integer phone1) {
		this.phone1 = phone1;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActivation() {
		return activation;
	}

	public void setActivation(Integer activation) {
		this.activation = activation;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
		result = prime * result
				+ ((activation == null) ? 0 : activation.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((identity == null) ? 0 : identity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((phone3 == null) ? 0 : phone3.hashCode());
		result = prime * result + rownum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (UUID == null) {
			if (other.UUID != null)
				return false;
		} else if (!UUID.equals(other.UUID))
			return false;
		if (activation == null) {
			if (other.activation != null)
				return false;
		} else if (!activation.equals(other.activation))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (phone3 == null) {
			if (other.phone3 != null)
				return false;
		} else if (!phone3.equals(other.phone3))
			return false;
		if (rownum != other.rownum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [rownum=" + rownum + ", UUID=" + UUID + ", name=" + name
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3="
				+ phone3 + ", password=" + password + ", activation="
				+ activation + ", identity=" + identity + ", company=" + company + "]";
	}

}
