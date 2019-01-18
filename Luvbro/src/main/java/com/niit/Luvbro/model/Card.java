package com.niit.Luvbro.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Card")
@Component
public class Card 
{
  @Id 
   private String card_Id;
   private long card_No;
   private String card_HolderName;
   private int card_expdate;
   private int card_expyear;
   private int card_expmnt;
   
   @ManyToOne
   @JoinColumn(name="U_id")
   private User user;
   
//public User getUser() {
//	return user;
//}
//public void setUser(User user) {
//	this.user = user;
//}
   
   public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Card() {
		this.card_Id ="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
public int getCard_expdate() {
	return card_expdate;
}
public void setCard_expdate(int card_expdate) {
	this.card_expdate = card_expdate;
}
public int getCard_expyear() {
	return card_expyear;
}
public void setCard_expyear(int card_expyear) {
	this.card_expyear = card_expyear;
}
public int getCard_expmnt() {
	return card_expmnt;
}
public void setCard_expmnt(int card_expmnt) {
	this.card_expmnt = card_expmnt;
}
public String getCard_Id() {
	return card_Id;
}
public void setCard_Id(String card_Id) {
	this.card_Id = card_Id;
}
public long getCard_No() {
	return card_No;
}
public void setCard_No(long card_No) {
	this.card_No = card_No;
}
public String getCard_HolderName() {
	return card_HolderName;
}
public void setCard_HolderName(String card_HolderName) {
	this.card_HolderName = card_HolderName;
}
   
}
