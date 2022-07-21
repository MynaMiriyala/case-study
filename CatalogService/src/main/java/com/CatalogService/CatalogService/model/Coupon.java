package com.CatalogService.CatalogService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Coupon")
public class Coupon {
	@Id
	private String couponId;
	@Field
	private String category;
	@Field
	private int count;
	@Field
	private String offer;
	@Field
	private String companyName;
	@Field
	private String image;

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", category=" + category + ", count=" + count + ", offer=" + offer
				+ ", companyName=" + companyName + ", image=" + image + "]";
	}
	

	public Coupon(String couponId, String category, int count, String offer, String companyName, String image) {
		super();
		this.couponId = couponId;
		this.category = category;
		this.count = count;
		this.offer = offer;
		this.companyName = companyName;
		this.image = image;
	}	
}
