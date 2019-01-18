package com.niit.Luvbro.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Billing")
@Component(value="billing")
public class Billing 
{
	 @Id
	  private String b_Id;
	  private String b_Houser_Number;
	  private String b_Landmark;
	  private String b_City;
	  private String b_State;
	  private String b_pincode;
	  
      @OneToOne(cascade=CascadeType.ALL)
      @JoinColumn(name="U_id")
      private User user;
      
      public Billing()
  	{
  		this.b_Id="bill"+UUID.randomUUID().toString().substring(30).toUpperCase();
  	}
      
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getB_pincode() {
		return b_pincode;
	}
	public void setB_pincode(String b_pincode) {
		this.b_pincode = b_pincode;
	}
	public String getB_Id() {
		return b_Id;
	}
	public void setB_Id(String b_Id) {
		this.b_Id = b_Id;
	}
	public String getB_Houser_Number() {
		return b_Houser_Number;
	}
	public void setB_Houser_Number(String b_Houser_Number) {
		this.b_Houser_Number = b_Houser_Number;
	}
	public String getB_Landmark() {
		return b_Landmark;
	}
	public void setB_Landmark(String b_Landmark) {
		this.b_Landmark = b_Landmark;
	}
	public String getB_City() {
		return b_City;
	}
	public void setB_City(String b_City) {
		this.b_City = b_City;
	}
	public String getB_State() {
		return b_State;
	}
	public void setB_State(String b_State) {
		this.b_State = b_State;
	}
	  
}
