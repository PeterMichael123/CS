package com.ce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="cs_user")
public class User {
	
	@GeneratedValue
	@Id
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//@NotEmpty(message="用户名不能为空")
	public String getUsername() {
		return Name;
	}
	public void setUsername(String username) {
		this.Name = username;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public User(){
		
	}
    public User(String name, String phoneNumber) {  
        this.Name = name;  
        this.PhoneNumber = phoneNumber;  
    } 
	private int id;
    private String Name; //用户名 《50
	private String PhoneNumber; //手机号 11位
}
