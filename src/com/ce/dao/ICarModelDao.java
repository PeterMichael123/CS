package com.ce.dao;

import java.util.ArrayList;
import java.util.List;

import com.ce.model.CarModel;
import com.ce.model.User;

public interface ICarModelDao extends IBaseDao<CarModel> {
	public ArrayList<CarModel> getCarModelList();
}
