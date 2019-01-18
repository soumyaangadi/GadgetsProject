package com.niit.Luvbro.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component

public class Supplier 
{
	@Id
	private String S_id;
	private String S_name;
	private long S_num;
	private String S_product;
	
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	public Supplier()
	{
		this.S_id="sup"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getS_id() {
		return S_id;
	}
	public void setS_id(String s_id) {
		S_id = s_id;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public long getS_num() {
		return S_num;
	}
	public void setS_num(long s_num) {
		S_num = s_num;
	}
	public String getS_product() {
		return S_product;
	}
	public void setS_product(String s_product) {
		S_product = s_product;
	}
	
	

}
