package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "standard")
public class standard {
	
	private int sid;
	private String name,status;
	private student student;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "standard")
	public student getStudent() {
		return student;
	}
	public void setStudent(student student) {
		this.student = student;
	}
	
	
	

}
