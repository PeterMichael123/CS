package com.ce.service;

import java.util.ArrayList;
import java.util.Date;

import com.ce.model.RequestDrive;

public interface IRequestDriveService {
	public int  saveRquest(String userName, String phoneNumber, String carModel, String seller, String data );
	public ArrayList<RequestDrive>  getRequestList();
}
