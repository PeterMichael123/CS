package com.ce.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ce.dao.IRequestDriveDao;
import com.ce.dao.ISellerDao;
import com.ce.model.Seller;


@Service("sellerService")
public class SellerService implements ISellerService {
	private ISellerDao sellerDao;
	
	public ArrayList<Seller> getSellerList(){
		return sellerDao.getSellerList();
	}
	
	public ISellerDao getRequestDriveDao() {
		return sellerDao;
	}
	
	@Resource
	public void setsellerDao(ISellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}
}
