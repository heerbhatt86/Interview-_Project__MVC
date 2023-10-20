package com.bean;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "student_mvc")
public class student {
	
	private int id;
	private String fisrt_name,last_name,created_date,dob;
	
	private standard standard;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "first_name")
	public String getFisrt_name() {
		return fisrt_name;
	}
	public void setFisrt_name(String fisrt_name) {
		this.fisrt_name = fisrt_name;
	}
	@Column(name = "last_name")
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
	@Column(name = "created_date")
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	@Column(name = "dob")
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public standard getStandard() {
		return standard;
	}
	public void setStandard(standard standard) {
		this.standard = standard;
	}
	

}
