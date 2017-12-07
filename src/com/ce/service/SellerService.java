package com.ce.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ce.dao.ISellerDao;
import com.ce.model.Seller;


@Service("sellerService")
public class SellerService implements ISellerService {
	ISellerDao sellerDao;
	
	public ArrayList<Seller> getSellerList(){
		return sellerDao.getSellerList();
	}
}
