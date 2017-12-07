package com.ce.service;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.NonUniqueResultException;
import org.springframework.stereotype.Service;

import com.ce.dao.IUserDao;
import com.ce.dao.ICarModelDao;
import com.ce.dao.ISellerDao;

@Service("userService")
public class UserService implements IUserService {
	private boolean SMSSupported = true;
	private IUserDao userDao;


	public Map<String, Object>  submit(String userName, String phoneNumber, String carModel, String seller, Date data ){
		 Map<String, Object> map = null;
		 
		 return map;
	}
	
	public int init(){
		
		return 0;
	}
	

}
