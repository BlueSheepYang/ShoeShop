package com.shoes.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderlist")
public class OrderList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="orderTime")
	private Date orderTime;
	
	@Column(name="orderCommodityId")
	private String orderCommodityId;
	
	@Column(name="orderCommodityName")
	private String orderCommodityName;
	
	@Column(name="orderTotalMoney")
	private String orderTotalMoney;
	
	@Column(name="orderCustomerId")
	private int orderCustomerId;
	
	@Column(name="orderCustomerName")
	private String orderCustomerName;
	
	@Column(name="orderCustomerAddress")
	private String orderCustomerAddress;
	
	@Column(name="orderCustomerPhone")
	private String orderCustomerPhone;
	
	@Column(name="orderHandleOrNot")
	private int orderHandleOrNot;
	
	@Column(name="orderCommodityType")
	private String orderCommodityType;

	
	
	public String getOrderCommodityType() {
		return orderCommodityType;
	}





	public void setOrderCommodityType(String orderCommodityType) {
		this.orderCommodityType = orderCommodityType;
	}





	public int getOrderHandleOrNot() {
		return orderHandleOrNot;
	}





	public void setOrderHandleOrNot(int orderHandleOrNot) {
		this.orderHandleOrNot = orderHandleOrNot;
	}





	public int getOrderId() {
		return orderId;
	}





	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}





	public Date getOrderTime() {
		return orderTime;
	}





	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}





	public String getOrderCommodityId() {
		return orderCommodityId;
	}





	public void setOrderCommodityId(String orderCommodityId) {
		this.orderCommodityId = orderCommodityId;
	}





	public String getOrderCommodityName() {
		return orderCommodityName;
	}





	public void setOrderCommodityName(String orderCommodityName) {
		this.orderCommodityName = orderCommodityName;
	}





	public String getOrderTotalMoney() {
		return orderTotalMoney;
	}





	public void setOrderTotalMoney(String orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}





	public int getOrderCustomerId() {
		return orderCustomerId;
	}





	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}





	public String getOrderCustomerName() {
		return orderCustomerName;
	}





	public void setOrderCustomerName(String orderCustomerName) {
		this.orderCustomerName = orderCustomerName;
	}





	public String getOrderCustomerAddress() {
		return orderCustomerAddress;
	}





	public void setOrderCustomerAddress(String orderCustomerAddress) {
		this.orderCustomerAddress = orderCustomerAddress;
	}





	public String getOrderCustomerPhone() {
		return orderCustomerPhone;
	}





	public void setOrderCustomerPhone(String orderCustomerPhone) {
		this.orderCustomerPhone = orderCustomerPhone;
	}


	

	public OrderList(Date orderTime, String orderCommodityId, String orderCommodityName, String orderTotalMoney,
			int orderCustomerId, String orderCustomerName, String orderCustomerAddress, String orderCustomerPhone,int orderHandleOrNot, String orderCommodityType) {
		this.orderTime = orderTime;
		this.orderCommodityId = orderCommodityId;
		this.orderCommodityName = orderCommodityName;
		this.orderTotalMoney = orderTotalMoney;
		this.orderCustomerId = orderCustomerId;
		this.orderCustomerName = orderCustomerName;
		this.orderCustomerAddress = orderCustomerAddress;
		this.orderCustomerPhone = orderCustomerPhone;
		this.orderHandleOrNot = orderHandleOrNot;
		this.orderCommodityType = orderCommodityType;
	}

	public OrderList() {
		
	}

}
