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
public class Classification {
	
	/**
	 * UUID标识,由原生UUID作为值
	 */
	private String UUID;
	
	/**
	 * 分类名称
	 */
	private String name;
	
	/**
	 * 是否激活
	 * 0为未激活
	 * 1为已激活
	 */
	private int activation;
	
	/**
	 * 权重值
	 * 目前上限999,权重值越大，排序越靠前
	 */
	private int weight;
	
	/**
	 * 其他备注
	 */
	private String text;

	
	//get，set区
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

	public int getActivation() {
		return activation;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	//hashCode与equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
		result = prime * result + activation;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + weight;
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
		Classification other = (Classification) obj;
		if (UUID == null) {
			if (other.UUID != null)
				return false;
		} else if (!UUID.equals(other.UUID))
			return false;
		if (activation != other.activation)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Classification [UUID=" + UUID + ", name=" + name
				+ ", activation=" + activation + ", weight=" + weight
				+ ", text=" + text + "]";
	}
	
	
	
}
