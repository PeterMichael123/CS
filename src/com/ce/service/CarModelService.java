package com.ce.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ce.dao.ICarModelDao;
import com.ce.model.CarModel;


@Service("carModelService")
public class CarModelService implements ICarModelService {
	
	ICarModelDao carModelDao;
	public ArrayList<CarModel>  getCarModelList(){
		return carModelDao.getCarModelList();
	}
}
