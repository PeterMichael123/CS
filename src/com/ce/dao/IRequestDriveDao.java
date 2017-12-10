package com.ce.dao;

import java.util.ArrayList;
import java.util.Date;

import com.ce.model.RequestDrive;


public interface IRequestDriveDao extends IBaseDao<RequestDrive> {
	public  ArrayList<RequestDrive> getRequestList();
	public  ArrayList<RequestDrive> getRequestList(	int pageSize,int pageNumber);
	public int saveRequest(String name, String phoneNumber, String carModel, String seller, String bookTime);
	public int getRequestNumber();
}
