package com.ce.dao;

import java.util.ArrayList;
import java.util.List;

import com.ce.model.Seller;
import com.ce.model.User;

public interface ISellerDao extends IBaseDao<Seller> {
	ArrayList<Seller> loadByCarModel(String carModel);
}
