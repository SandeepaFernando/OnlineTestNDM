package springbootpayment.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="payments")
@EntityListeners(AuditingEntityListener.class)

public class Payment implements Serializable{
	private static final long serialVersionUID = 1143993377101043360L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long payment_id;
	private String order_id;
	private String user_id;
	private Long fullAmount; 
	private String date;
	
	public Long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Long getFullAmount() {
		return fullAmount;
	}
	public void setFullAmount(Long fullAmount) {
		this.fullAmount = fullAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
