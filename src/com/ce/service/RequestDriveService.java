package com.ce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ce.dao.ICarModelDao;
import com.ce.dao.IRequestDriveDao;
import com.ce.dao.ISellerDao;
import com.ce.model.RequestDrive;

@Service("requestDriveService")
public class RequestDriveService implements IRequestDriveService{
	private IRequestDriveDao requestDriveDao;
	
	
	public int saveRquest(String userName, String phoneNumber, String carModel, String seller, String bookTime ){
		requestDriveDao.saveRequest(userName, phoneNumber, carModel, seller, bookTime);
		return 0;
	}
	
	public ArrayList<RequestDrive> getRequestList(){
		return requestDriveDao.getRequestList();
	}

	public IRequestDriveDao getRequestDriveDao() {
		return requestDriveDao;
	}
	
	@Resource
	public void setRequestDriveDao(IRequestDriveDao requestDriveDao) {
		this.requestDriveDao = requestDriveDao;
	}


}
