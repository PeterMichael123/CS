package com.ce.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
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

import com.ce.model.User;
import com.ce.service.IUserService;

@Controller
@RequestMapping(value="/mobile")
public class UserController {
		private IUserService userService;
		
        @RequestMapping(value="/hi",method=RequestMethod.GET)
        @ResponseBody
        public String hello(){
        	//userService.submit();
            return "test";
        }
        
        @RequestMapping(value="/user", method=RequestMethod.GET)
        public ModelAndView user() {
        System.out.println("user login()....");
           User user = new User();//("weijian","18611732351");
           user.setUsername("weijian");
           user.setPhoneNumber("18611732351");
           ModelAndView modelAndView = new ModelAndView("requestbook", "command",user);
           return modelAndView;
        }

}