package com.livio.mapping.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;
	
	@Column(name="customer_id")
	private short customerId;
	
	@Column(name="staff_id")
	private byte staffId;
	
	@Column(name="rental_id")
	private int rentalId;
	
	@Column(name="amount")
	private double amount;
	
	
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	public Payment() {}

	public Payment(short customerId, byte staffId, int rentalId, double amount, LocalDateTime paymentDate) {
		super();
		this.customerId = customerId;
		this.staffId = staffId;
		this.rentalId = rentalId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public short getCustomerId() {
		return customerId;
	}

	public void setCustomerId(short customerId) {
		this.customerId = customerId;
	}

	public byte getStaffId() {
		return staffId;
	}

	public void setStaffId(byte staffId) {
		this.staffId = staffId;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", customerId=" + customerId + ", staffId=" + staffId + ", rentalId="
				+ rentalId + ", amount=" + amount + ", paymentDate=" + paymentDate + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
}
