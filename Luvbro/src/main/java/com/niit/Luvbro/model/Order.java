package com.niit.Luvbro.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//import java.util.List;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Orders")
@Component
public class Order 
{
	@Id
	private String o_id;
	private double o_grandtotal;
	private String o_orddate;
	private String o_ordtime;
	
	private static final DateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
	private static final DateFormat stf=new SimpleDateFormat("HH:MM:SS");
	
	@OneToOne
	@JoinColumn(name="b_Id")
	private Billing billing;
	
	@OneToOne
	@JoinColumn(name="s_id")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="pay_id")
	private Pay pay;
	
	@OneToOne
	@JoinColumn(name="U_id")
	private User user;
	
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderItems;


	

	
	
//	Order()
//	{
//		Date date = new Date();
//		o_orddate=sdf.format(date);
//		Date date1=new Date();
//		o_ordtime=stf.format(date1);
//		this.o_id=UUID.randomUUID().toString().substring(30).toUpperCase();
//	}

	public Order() {
		Date date = new Date();
		o_orddate=sdf.format(date);
		Calendar cal = Calendar.getInstance();
		Date date1 = new Date();
		o_ordtime=stf.format(date1);
		this.o_id = UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public String getO_id() {
		return o_id;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public double getO_grandtotal() {
		return o_grandtotal;
	}

	public void setO_grandtotal(double o_grandtotal) {
		this.o_grandtotal = o_grandtotal;
	}

	public String getO_orddate() {
		return o_orddate;
	}

	public void setO_orddate(String o_orddate) {
		this.o_orddate = o_orddate;
	}

	public String getO_ordtime() {
		return o_ordtime;
	}

	public void setO_ordtime(String o_ordtime) {
		this.o_ordtime = o_ordtime;
	}	

}
