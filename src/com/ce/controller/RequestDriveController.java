package com.ce.controller;

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

import com.ce.model.RequestDrive;
import com.ce.model.User;
import com.ce.service.IRequestDriveService;
import com.ce.service.IUserService;

@Controller
@RequestMapping(value="/mobile")
public class RequestDriveController {
		private IRequestDriveService requestDriveService;
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
       /* 
        requestDrive.setUserName("please input your name");
        requestDrive.setPhoneNumber("");
        requestDrive.setCarModel("Benze");
        requestDrive.setSeller("123");
        requestDrive.setBookTime(new Date());
        requestDrive.setSubmitTime(new Date());*/
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

    	@RequestMapping(value="/getrecord",method=RequestMethod.GET)
    	@ResponseBody
        private Map<String, Object> getRequestRecord() throws IOException {  
    		Map<String, Object> map = null;
    		map = new HashMap<String, Object>();
            //得到客户端传递的页码和每页记录数，并转换成int类型  
            //int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
            //int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));  
            //String orderNum = request.getParameter("orderNum");  
              
            //分页查找商品销售记录，需判断是否有带查询条件  
            List<RequestDrive> sellRecordList = requestDriveService.getRequestList();//.querySellRecordByPage(pageNumber, pageSize, orderNum);  
              
            //将商品销售记录转换成json字符串  
            //String sellRecordJson = requestDriveService.getSellRecordJson(sellRecordList);  
            //得到总记录数  
            //int total = sellRecordService.countSellRecord(orderNum);  
              
            //{\"total\":" + total + ",\"rows\":" + sellRecordJson + "}";  
            //需要返回的数据有总记录数和行数据  
            map.put("total", sellRecordList.size());
            map.put("rows", sellRecordList);
            return map;  
        }          
        
    	//get seller list
        @ModelAttribute("sellerList")
        public Map<String, String> getsellerList()
        {
           Map<String, String> sellerList = new HashMap<String, String>();
           sellerList.put("US", "United States");
           sellerList.put("CH", "China");
           return sellerList;
        }
    	
        //get carModel list
        @ModelAttribute("carModelList")
        public Map<String, String> getCarModelList()
        {
           Map<String, String> carModelList = new HashMap<String, String>();
           carModelList.put("US", "United States");
           carModelList.put("CH", "China");
           return carModelList;
        }
}