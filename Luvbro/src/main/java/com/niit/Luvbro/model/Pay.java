package com.niit.Luvbro.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Pay")
@Component
public class Pay 
{
	@Id
	private String pay_id;
	private String pay_way;
	private String pay_status;
	
	public Pay() 
	{
		this.pay_id = "PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();

	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getPay_way() {
		return pay_way;
	}
	public void setPay_way(String pay_way) {
		this.pay_way = pay_way;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	
	

}
