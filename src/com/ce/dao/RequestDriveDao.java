package com.ce.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ce.model.RequestDrive;
import com.ce.model.Util;

@Repository("requestDriveDao")
public class RequestDriveDao extends BaseDao<RequestDrive>  implements IRequestDriveDao {
	@Override
	public int getRequestNumber(){
		String hql = "select count(*) from RequestDrive";
		Query u = this.getSession().createQuery(hql);	
		int count = ((Number)u.uniqueResult()).intValue(); 
		//int count = (int)((Number)u).intValue();
		return count;
	}
	
	
	@Override
	public  ArrayList<RequestDrive> getRequestList() {
		String hql = "from RequestDrive";
		Query u = this.getSession().createQuery(hql);
		ArrayList<RequestDrive> list = (ArrayList<RequestDrive>)u.list();
		return list;
	}

	@Override
	public  ArrayList<RequestDrive> getRequestList(int pageSize,int pageNumber) {
		String hql = "from RequestDrive ";
		int begin = pageNumber;
		//int end = begin+pageSize; 
		Query u = this.getSession().createQuery(hql);
		u.setFirstResult(begin);
		u.setMaxResults(pageSize);
		ArrayList<RequestDrive> list = (ArrayList<RequestDrive>)u.list();
		return list;
	}
	
	@Override
	public int saveRequest(String name, String phoneNumber, String carModel, String seller, String bookTime){
		RequestDrive rd = new RequestDrive();
		rd.setUserName(name);
		rd.setPhoneNumber(phoneNumber);
		rd.setSeller(seller);
		rd.setCarModel(carModel);
		rd.setBookTime(bookTime);
		this.add(rd);
		return 0;
	}
	
}
