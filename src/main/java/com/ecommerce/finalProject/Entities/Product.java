package com.ecommerce.finalProject.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imgurl")
    private String imageUrl;

    @Column(name = "pname")
    private String productName;

    @Column(name = "prating")
    private int productRating;

    @Column(name = "preview")
    private int productReviews;

    @Column(name = "pmaterial")
    private String productMaterial;

    @Column(name = "pweight")
    private String productWeight;

    @Column(name = "pfinish")
    private String productFinish;

    @Column(name = "pdesc")
    private String productDescription;

    @Column(name = "pgender")
    private String productGender;

    @Column(name = "pstyle")
    private String productStyle;

    @Column(name = "pinfo")
    private String productInfo;

    @Column(name = "pprice")
    private double productPrice;

    @Column(name = "ptotal")
    private double totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	public int getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(int productReviews) {
		this.productReviews = productReviews;
	}

	public String getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	public String getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductFinish() {
		return productFinish;
	}

	public void setProductFinish(String productFinish) {
		this.productFinish = productFinish;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductGender() {
		return productGender;
	}

	public void setProductGender(String productGender) {
		this.productGender = productGender;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product() {
		super();
	}

	public Product(Long id, String imageUrl, String productName, int productRating, int productReviews,
			String productMaterial, String productWeight, String productFinish, String productDescription,
			String productGender, String productStyle, String productInfo, double productPrice, double totalPrice) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.productName = productName;
		this.productRating = productRating;
		this.productReviews = productReviews;
		this.productMaterial = productMaterial;
		this.productWeight = productWeight;
		this.productFinish = productFinish;
		this.productDescription = productDescription;
		this.productGender = productGender;
		this.productStyle = productStyle;
		this.productInfo = productInfo;
		this.productPrice = productPrice;
		this.totalPrice = totalPrice;
	}

	
  
}
