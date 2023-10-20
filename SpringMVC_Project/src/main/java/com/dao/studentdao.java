package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.bean.standard;
import com.bean.student;

public class studentdao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public  void insertStandard(standard s) {
		
		hibernateTemplate.saveOrUpdate(s);
		
	}
	@Transactional
	public  void insertStudent(student s) {
		
		hibernateTemplate.saveOrUpdate(s);
		
	}
	public List<student> getallstudent(){
		return hibernateTemplate.loadAll(student.class);
	}
	public List<standard> getallstandard(){
		return hibernateTemplate.loadAll(standard.class);
	}
	public student getstudent(int id) {
		return hibernateTemplate.get(student.class, id);
	}
	public standard getstandard(int  sid) {
		return hibernateTemplate.get(standard.class, sid);
	}
	@Transactional
	public void deletestudent(int id) {
		
		student student=hibernateTemplate.get(student.class, id);
		
		hibernateTemplate.delete(student);
	}

}
