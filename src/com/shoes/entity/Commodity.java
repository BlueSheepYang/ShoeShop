package com.shoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="commodity")
public class Commodity {
	@Id
	@GenericGenerator(name="system_uuid",strategy="uuid")
	@Column(name="commodityId",unique = true, nullable = false, length = 20)
	private String commodityId;
	
	@Column(name="commodityName")
	private String commodityName;
	
	@Column(name="commodityFitPeople")
	private String commodityFitPeople;
	
	@Column(name="commodityColor")
	private String commodityColor;
	
	@Column(name="commoditySeason")
	private String commoditySeason;
	
	@Column(name="commodityWhetherInStock")
	private String commodityWhetherInStock;
	
	@Column(name="commodityPrice")
	private Double commodityPrice;
	
	@Column(name="commoditySex")
	private String commoditySex;
	
	@Column(name="commodityDescription")
	private String commodityDescription;
	
	@Column(name="commodityNumber")
	private int commodityNumber;
	
	@Column(name="commodityPictureLink")
	private String commodityPictureLink;

	@Column(name="commodityType")
	private String commodityType;
	
	
	
	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityFitPeople() {
		return commodityFitPeople;
	}

	public void setCommodityFitPeople(String commodityFitPeople) {
		this.commodityFitPeople = commodityFitPeople;
	}

	public String getCommodityColor() {
		return commodityColor;
	}

	public void setCommodityColor(String commodityColor) {
		this.commodityColor = commodityColor;
	}

	public String getCommoditySeason() {
		return commoditySeason;
	}

	public void setCommoditySeason(String commoditySeason) {
		this.commoditySeason = commoditySeason;
	}

	public String getCommodityWhetherInStock() {
		return commodityWhetherInStock;
	}

	public void setCommodityWhetherInStock(String commodityWhetherInStock) {
		this.commodityWhetherInStock = commodityWhetherInStock;
	}

	public Double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommoditySex() {
		return commoditySex;
	}

	public void setCommoditySex(String commoditySex) {
		this.commoditySex = commoditySex;
	}

	public String getCommodityDescription() {
		return commodityDescription;
	}

	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
	}

	
	public int getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public String getCommodityPictureLink() {
		return commodityPictureLink;
	}

	public void setCommodityPictureLink(String commodityPictureLink) {
		this.commodityPictureLink = commodityPictureLink;
	}
	
	

	public Commodity(String commodityId, String commodityName, String commodityFitPeople,
			String commodityColor, String commoditySeason, String commodityWhetherInStock, Double commodityPrice,
			String commoditySex, String commodityDescription, int commodityNumber, String commodityPictureLink,String commodityType) {
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityFitPeople = commodityFitPeople;
		this.commodityColor = commodityColor;
		this.commoditySeason = commoditySeason;
		this.commodityWhetherInStock = commodityWhetherInStock;
		this.commodityPrice = commodityPrice;
		this.commoditySex = commoditySex;
		this.commodityDescription = commodityDescription;
		this.commodityNumber = commodityNumber;
		this.commodityPictureLink = commodityPictureLink;
		this.commodityType = commodityType;
	}
	
	public Commodity() {}

	@Override
	public String toString() {
		return "Commodity [CommodityId=" + commodityId + ", commodityName=" + commodityName + ", CommodityType="
				+ ", commodityFitPeople=" + commodityFitPeople + ", commodityColor=" + commodityColor
				+ ", commoditySeason=" + commoditySeason + ", commodityWhetherInStock=" + commodityWhetherInStock
				+ ", commodityPrice=" + commodityPrice + ", commoditySex=" + commoditySex + "]";
	}
	
	
}
