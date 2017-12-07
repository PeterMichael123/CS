package com.ce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ce.model.CarModel;
import com.ce.model.RequestDrive;
import com.ce.model.SystemContext;
import com.ce.model.User;

@Repository("carModelDao")
public class CarModelDao extends BaseDao<CarModel> implements ICarModelDao {
	
	@Override
	public ArrayList<CarModel> getCarModelList(){
		String hql = "from CarModel";
		Query u = this.getSession().createQuery(hql);
		ArrayList<CarModel> list = (ArrayList<CarModel>)u.list();
		return list;
	}
}
