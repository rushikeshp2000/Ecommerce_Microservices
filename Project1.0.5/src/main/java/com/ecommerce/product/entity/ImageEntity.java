package com.ecommerce.product.entity;

import org.bson.types.Binary;

public class ImageEntity {

	private String imageName;
	
	private String imageType;

	private Binary imagedata;

	public ImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageEntity(String imageName, String imageType, Binary imagedata) {
		super();
		this.imageName = imageName;
		this.imageType = imageType;
		this.imagedata = imagedata;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Binary getImagedata() {
		return imagedata;
	}

	public void setImagedata(Binary imagedata) {
		this.imagedata = imagedata;
	}

	@Override
	public String toString() {
		return "ImageEntity [imageName=" + imageName + ", imageType=" + imageType + ", imagedata=" + imagedata + "]";
	}
	
	
}
