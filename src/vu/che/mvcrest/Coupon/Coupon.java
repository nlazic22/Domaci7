package vu.che.mvcrest.Coupon;

import java.io.Serializable;

public class Coupon implements Serializable {
	
	private long id;
	private Shop shop;
	private String product;
	private float discountedPrice;
	private float originalPrice;
	private float discount;
	
	
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(float dicountedPrice) {
		this.discountedPrice = dicountedPrice;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	
	

}
