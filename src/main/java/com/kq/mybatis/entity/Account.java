package com.kq.mybatis.entity;
/**
 * TODO
 * @author kongqi
 * @date  2018-04-27 10:21 
 * @since 
 */
public class Account {
	
	private Long id;
	private String username;
	private String name;
	private Integer age;
	
	private Location location;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", location="
				+ location + "]";
	}
	
	
	

}
