package com.niit.Luvbro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Shipping")
@Component
public class Shipping 
{
	@Id
	private String s_id;
	private String s_houseno;
	private String s_landmark;
	private String s_country;
	private String s_email;
	private String s_city;
	private String s_state;
	private String s_pincode;

	
	@ManyToOne
	@JoinColumn(name="U_id")
	private User user;
	
public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_houseno() {
		return s_houseno;
	}
	public void setS_houseno(String s_houseno) {
		this.s_houseno = s_houseno;
	}
	public String getS_landmark() {
		return s_landmark;
	}
	public void setS_landmark(String s_landmark) {
		this.s_landmark = s_landmark;
	}
	public String getS_country() {
		return s_country;
	}
	public void setS_country(String s_country) {
		this.s_country = s_country;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	public String getS_pincode() {
		return s_pincode;
	}
	public void setS_pincode(String s_pincode) {
		this.s_pincode = s_pincode;
	}
	

}
