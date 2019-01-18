package com.niit.Luvbro.model;

import java.util.UUID;

import javax.persistence.CascadeType;

//import java.util.List;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="User")
@Component
public class User 
{
	@Id
	private String U_id;
	private String U_name;
	private long U_phoneno;
	private String U_email_addr;
	private String U_password;
	private String U_rptpwd;
	private String Role="ROLE_USER";
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cart_Id")
	private Cart cart;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="b_Id")
	private Billing billing;
	
	public User()
	{
		this.U_id="usr"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
////	@OneToMany(mappedBy="user")
////	private List<Card> card;
//	
////	public List<Card> getCard() {
////		return card;
////	}
////	public void setCard(List<Card> card) {
////		this.card = card;
////	}
//	public Billing getBilling() {
//		return billing;
//	}
//	public void setBilling(Billing billing) {
//		this.billing = billing;
//	}
//	
//	public Cart getCart() {
//		return cart;
//	}
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	public String getU_name() {
		return U_name;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public void setU_name(String u_name) {
		U_name = u_name;
	}
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	
	
	public long getU_phoneno() {
		return U_phoneno;
	}
	public void setU_phoneno(long u_phoneno) {
		U_phoneno = u_phoneno;
	}
	public String getU_password() {
		return U_password;
	}
	public void setU_password(String u_password) {
		U_password = u_password;
	}
	public String getU_email_addr() {
		return U_email_addr;
	}
	public void setU_email_addr(String u_email_addr) {
		U_email_addr = u_email_addr;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getU_rptpwd() {
		return U_rptpwd;
	}
	public void setU_rptpwd(String u_rptpwd) {
		U_rptpwd = u_rptpwd;
	}

}
