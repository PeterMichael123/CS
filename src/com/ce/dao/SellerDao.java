package com.ce.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ce.model.CarModel;
import com.ce.model.Seller;
@Repository("sellerDao")
public class SellerDao extends BaseDao<Seller> implements ISellerDao {

	@Override
	public ArrayList<Seller> getSellerList(){
		String hql = "from Seller";
		Query u = this.getSession().createQuery(hql);
		ArrayList<Seller> list = (ArrayList<Seller>)u.list();
		return list;
	}
}
