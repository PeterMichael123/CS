package com.ce.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ce.model.Seller;
@Repository("sellerDao")
public class SellerDao extends BaseDao<Seller> implements ISellerDao {

	@Override
	public ArrayList<Seller> loadByCarModel(String carModel){
		
		// TODO Auto-generated method stub
		ArrayList<Seller> u;
		u = (ArrayList<Seller>)this.getSession().createQuery("from User where Name=?").setParameter(0,carModel).uniqueResult();
		return u;
	}
}
