package com.ce.controller;

//jdbc:mysql://127.0.0.1:3306/carsell?useUnicode=true&characterEncoding=utf8
//http://39.106.165.11:8080/
//jdbc:mysql://39.106.165.11:3306/carsell?useUnicode=true&characterEncoding=utf8
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ce.model.CarModel;
import com.ce.model.RequestDrive;
import com.ce.model.Seller;
import com.ce.model.User;
import com.ce.service.ICarModelService;
import com.ce.service.IRequestDriveService;
import com.ce.service.ISellerService;
import com.ce.service.IUserService;

@Controller
@RequestMapping(value="/mobile")
public class RequestDriveController {
		private ICarModelService carModelService;
		private ISellerService sellerService;
		private IRequestDriveService requestDriveService;
		
		public ICarModelService getCarModelService() {
			return carModelService;
		}
		@Resource
		public void setCarModelService(ICarModelService carModelService) {
			this.carModelService = carModelService;
		}
		public ISellerService getSellerService() {
			return sellerService;
		}
		@Resource
		public void setSellerService(ISellerService sellerService) {
			this.sellerService = sellerService;
		}
		
		public IRequestDriveService getRequestDriveService() {
			return requestDriveService;
		}
		@Resource
		public void setRequestDriveService(IRequestDriveService requestDriveService) {
			this.requestDriveService = requestDriveService;
		}
		
		//init and input
        @RequestMapping(value="/requestdrive", method=RequestMethod.GET)
        public ModelAndView requestdrive() {
        	RequestDrive requestDrive = new RequestDrive();
        	ModelAndView modelAndView = new ModelAndView("requestbook", "command",requestDrive);
        	return modelAndView;
        }

        // save
        @RequestMapping(value="/submitrequest", method=RequestMethod.POST)
        public String submitrequest(@ModelAttribute("RequestDrive")RequestDrive requestDrive, ModelMap model) 
        {
           String name = requestDrive.getUserName();
           String phoneNumber = requestDrive.getPhoneNumber();
           String carModel = requestDrive.getCarModel();
           String seller = requestDrive.getSeller();
           //Date date 
           String date = requestDrive.getBookTime();
           int re = requestDriveService.saveRquest(name, phoneNumber,carModel, seller, date);

           if(re == 0){
        	   //success
               return "submitrequestsuccess";
           }else {
        	   // failed
        	   return "submitrequestfail";
           }
        }
        
        //get and show
        @RequestMapping(value="/getresult", method=RequestMethod.GET)
        public ModelAndView getresult() 
        {
            //get data from database; 
            RequestDrive requestDrive = new RequestDrive();
            ModelAndView modelAndView = new ModelAndView("getrequestlist", "command",requestDrive);
            return modelAndView;
        }

        //limit: params.limit,   //页面大小
        //offset: params.offset,  //页码
    	@RequestMapping(value="/getrecord",method=RequestMethod.POST)
    	@ResponseBody
        private Map<String, Object> getrecord(int limit,int offset) throws IOException {  
    		Map<String, Object> map = null;
    		map = new HashMap<String, Object>();
            //得到客户端传递的页码和每页记录数，并转换成int类型  
            //分页查找商品销售记录，需判断是否有带查询条件  
            //List<RequestDrive> sellRecordList = requestDriveService.getRequestList();
    		List<RequestDrive> sellRecordList = requestDriveService.getRequestList(limit, offset);  
            //需要返回的数据有总记录数和行数据  
    		int total = requestDriveService.getRequestNumber();
            map.put("total", total);
            map.put("rows", sellRecordList);
            return map;  
        }          
        
    	//get seller list
        @ModelAttribute("sellerList")
        public Map<String, String> getsellerList()
        {
           Map<String, String> sellerList = new HashMap<String, String>();
           ArrayList sList = sellerService.getSellerList();
           
           int size = sList.size();
           for(int i = 0; i<size; ++i){
        	   //Seller s = (Seller)sList.get(i);
               String name = ((Seller)sList.get(i)).getName();
        	   sellerList.put(name, name);        	   
           }
           
           return sellerList;
        }
    	
        //get carModel list
        @ModelAttribute("carModelList")
        public Map<String, String> getCarModelList()
        {
           Map<String, String> carModelList = new HashMap<String, String>();
           ArrayList cList  = carModelService.getCarModelList();
           int size = cList.size();
           for(int i = 0; i<size; ++i){
        	   String name = ( (CarModel)cList.get(i)).getName();
        	   //CarModel c = (CarModel)cList.get(i);
        	   carModelList.put(name, name);        	   
           }
           return carModelList;
        }

}