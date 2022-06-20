package com.javaex.vo;

public class UserVo {
	
	//필드
	private String id;
	private String password;
	private String name;
	private String gender;
	
	
	//생성자
	public UserVo() {
	}
	
	
	//메소드-gs
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	
	//메소드-일반
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
}
