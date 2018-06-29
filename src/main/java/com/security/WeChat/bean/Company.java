package com.security.WeChat.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
* Classification表的Bean,用于封装分类信息
* @author GSKJ
*
*/
@Component
//这个注解用于在配置文件中进行注入。
@ConfigurationProperties(prefix="Test") 
//这个注解是读取指定的配置文件。
@PropertySource(value={"classpath:test.properties"})
@SuppressWarnings("all")
public class Company {
	
	/**
	 * UUID,它由随机的uuid与时间戳组成.
	 * 
	 */
	private String UUID;
	
	/**
	 * name,公司/商铺的名称
	 * 
	 */
	private String name;
	
	/**
	 * img,图片路径及名称
	 * 
	 */
	private String img;
	
	/**
	 * userUUID,对应User表的UUID
	 * 
	 */
	private String userUUID;
	
	/**
	 * address,公司/商铺的地址
	 * 
	 */
	private String address;
	
	/**
	 * propaganda,活动宣传语
	 * 
	 */
	private String propaganda;
	
	/**
	 * text,介绍与公司备注
	 * 
	 */
	private String text;
	
	/**
	 * classificationUUID,对应着classification表的UUID
	 * 
	 */
	private String classificationUUID;
	
	/**
	 * activation,设置是否可用
	 * 0为未激活
	 * 1为已激活
	 * 
	 */
	private int activation;

	/**
	 * 子类
	 * 
	 */
	private String subclass;
	
	//Get,Set
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPropaganda() {
		return propaganda;
	}

	public void setPropaganda(String propaganda) {
		this.propaganda = propaganda;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getClassificationUUID() {
		return classificationUUID;
	}

	public void setClassificationUUID(String classificationUUID) {
		this.classificationUUID = classificationUUID;
	}
	
	public int getActivation() {
		return activation;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}

	public String getSubclass() {
		return subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	
	
	//hashCode,equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
		result = prime * result + activation;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime
				* result
				+ ((classificationUUID == null) ? 0 : classificationUUID
						.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((propaganda == null) ? 0 : propaganda.hashCode());
		result = prime * result
				+ ((subclass == null) ? 0 : subclass.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result
				+ ((userUUID == null) ? 0 : userUUID.hashCode());
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
		Company other = (Company) obj;
		if (UUID == null) {
			if (other.UUID != null)
				return false;
		} else if (!UUID.equals(other.UUID))
			return false;
		if (activation != other.activation)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (classificationUUID == null) {
			if (other.classificationUUID != null)
				return false;
		} else if (!classificationUUID.equals(other.classificationUUID))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (propaganda == null) {
			if (other.propaganda != null)
				return false;
		} else if (!propaganda.equals(other.propaganda))
			return false;
		if (subclass == null) {
			if (other.subclass != null)
				return false;
		} else if (!subclass.equals(other.subclass))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userUUID == null) {
			if (other.userUUID != null)
				return false;
		} else if (!userUUID.equals(other.userUUID))
			return false;
		return true;
	}

	
	//toString
	@Override
	public String toString() {
		return "Company [UUID=" + UUID + ", name=" + name + ", img=" + img
				+ ", userUUID=" + userUUID + ", address=" + address
				+ ", propaganda=" + propaganda + ", text=" + text
				+ ", classificationUUID=" + classificationUUID
				+ ", activation=" + activation + ", subclass=" + subclass + "]";
	}

}
