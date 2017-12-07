package com.ce.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ce.model.CarModel;
import com.ce.model.SystemContext;
import com.ce.model.User;

@Repository("carModelDao")
public class CarModelDao extends BaseDao<CarModel> implements ICarModelDao {

}
