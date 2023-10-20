package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bean.standard;
import com.bean.student;
import com.dao.studentdao;

@Controller
public class MyController {

	ApplicationContext a= new ClassPathXmlApplicationContext("beans.xml");
	studentdao sdao=(studentdao) a.getBean("studentdao"); 
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index() {
		
		return "insert";
	}
	@RequestMapping(value = "insert_standard",method = RequestMethod.POST)
	public String insertstandard(HttpServletRequest request,HttpServletResponse response) {
		
		standard s= new standard();
		s.setName(request.getParameter("name"));
		s.setStatus(request.getParameter("status"));
	
		sdao.insertStandard(s);
		return "insert_standard";
	}
	@RequestMapping(value = "standard",method = RequestMethod.GET)
	public String insertstandard() {
		
		return "insert_standard";
	}
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpServletResponse response) {
		
		student s1=new student();
		int id=Integer.parseInt(request.getParameter("standard"));
		standard s2= sdao.getstandard(id);
		s1.setFisrt_name(request.getParameter("first_name"));
		s1.setLast_name(request.getParameter("last_name"));
		s1.setDob(request.getParameter("dob"));
		s1.setCreated_date(java.time.LocalDate.now().toString());
		s1.setStandard(s2);
		
	
		
		sdao.insertStudent(s1);
		return "show";
	}
	
	
}
