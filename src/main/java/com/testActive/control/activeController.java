package com.testActive.control;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.testActive.consumer;
import com.testActive.producer;

@Controller
public class activeController {
	@Resource(name="myDestination")
	private Destination dest;
	
	@Resource(name="consumerImpl")
	private consumer spend;
	
	@Resource(name="producerImpl")
	private producer fac;	
	
       @RequestMapping(value="/pro",method=RequestMethod.POST)
       public ModelAndView sendData(@RequestParam("info")String info,HttpServletRequest request){
    	   ModelAndView model=new ModelAndView();
    	   fac.sendMsg(dest, info);
    	   System.out.println("the message already send"); 
    	   request.setAttribute("hint", "success send");
    	   return model;
       }
       
       @RequestMapping(value="/con",method=RequestMethod.GET)
       public ModelAndView getData(HttpServletRequest request){
    	   ModelAndView model=new ModelAndView();
    	   TextMessage text=spend.getMessage(dest);    	   
    	   if(text!=null) {
    		   request.setAttribute("hint", "data take");
        	   System.out.println("the message already have been take"); 
    	   }    	
    	   else{
    		   request.setAttribute("hint", "data empty");
    		   System.out.println("nodata at destination");
    	   }
    	   return model;
       }
       
       
       @RequestMapping(value="/load")
       public String onload(){
    	  return"index";
       }
       
       
}
