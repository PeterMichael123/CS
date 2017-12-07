package com.ce.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cs_requestdrive")
public class RequestDrive {
	private int id;
    private String UserName; 
    private String PhoneNumber; 
    private String CarModel;  
    private String Seller; 
    private String BookTime;

	@GeneratedValue
	@Id
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getSeller() {
		return Seller;
	}
	public void setSeller(String seller) {
		Seller = seller;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getCarModel() {
		return CarModel;
	}
	public void setCarModel(String carModel) {
		CarModel = carModel;
	}
	public String getBookTime() {
		return BookTime;
	}
	public void setBookTime(String bookTime) {
		BookTime = bookTime;
	}
}
