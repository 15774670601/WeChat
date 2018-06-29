package com.security.WeChat.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//test的实体
@Component
@SuppressWarnings("all")
@ConfigurationProperties(prefix="Test")  //（配置文件注入）这个注解用于在配置文件中进行注入。
@PropertySource(value={"classpath:test.properties"})// 这个注解是读取指定的配置文件。
public class test {
	
	private String name;	
	private String age;
	//@Value("乱码? 不存在的!")   //（注解注入）这个注解用于直接注入。
	private String pz;
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPz() {
		return pz;
	}
	public void setPz(String pz) {
		this.pz = pz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "test [name=" + name + ", age=" + age + ", pz=" + pz + ", id="
				+ id + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pz == null) ? 0 : pz.hashCode());
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
		test other = (test) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pz == null) {
			if (other.pz != null)
				return false;
		} else if (!pz.equals(other.pz))
			return false;
		return true;
	}
	
	public test(){
		
	}
	
	public test(String name,String age,Integer id){
		this.name = name;
		this.age = age;
		this.id = id;
	}
}
