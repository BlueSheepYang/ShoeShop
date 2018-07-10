package com.shoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoppingcar")
public class ShoppingCar {
		
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="userNickName")
	private String userNickName;
	
	@Column(name="productId")
	private String productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="price")
	private String price;
	
	@Column(name="productNumber")
	private String productNumber;
	
	@Column(name="sum")
	private String sum;
	
	@Column(name="productKind")
	private String productKind;
	
	

	public String getProductKind() {
		return productKind;
	}

	public void setProductKind(String productKind) {
		this.productKind = productKind;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ShoppingCarList [userNickName=" + userNickName + ", productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", productNumber=" + productNumber + ", sum=" + sum + "]";
	}

	public ShoppingCar(String userNickName, String productId, String productName, String price, String productNumber,
			String sum,String type) {
		this.userNickName = userNickName;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productNumber = productNumber;
		this.sum = sum;
		this.productKind = type;
	}
	
	public ShoppingCar() {
		
	}
	
}
