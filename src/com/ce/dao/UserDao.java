package com.ce.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ce.model.SystemContext;
import com.ce.model.User;
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

}
