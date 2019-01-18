package com.niit.Luvbro.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class Product 
{

@Id
	private String p_id;
	private String p_name;
	private int p_q;
	private float p_c;
	private String des;
	
	@Transient
	private MultipartFile pimg;
	
	@ManyToOne
	@JoinColumn(name="C_id")
	private Category category;
	
	public Product()
	{
		this.p_id="pro"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@ManyToOne
	@JoinColumn(name="S_id")
	private Supplier supplier;
public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	//	
//	public Supplier getSupplier() {
//		return supplier;
//	}
//	public void setSupplier(Supplier supplier) {
//		this.supplier = supplier;
//	}
//	public Category getCategory() {
//		return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_q() {
		return p_q;
	}
	public void setP_q(int p_q) {
		this.p_q = p_q;
	}
	public float getx() {
		return p_c;
	}
	
	public float getP_c() {
		return p_c;
	}

	public void setP_c(float p_c) {
		this.p_c = p_c;
	}

	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}

}
