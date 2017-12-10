package com.ce.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ce.dao.ICarModelDao;
import com.ce.dao.ISellerDao;
import com.ce.model.CarModel;


@Service("carModelService")
public class CarModelService implements ICarModelService {
	
	ICarModelDao carModelDao;
	
	public ArrayList<CarModel>  getCarModelList(){
		return carModelDao.getCarModelList();
	}
	
	
	public ICarModelDao getCarModelDao() {
		return carModelDao;
	}
	
	@Resource
	public void setCarModelDao(ICarModelDao carModelDao) {
		this.carModelDao = carModelDao;
	}
}
