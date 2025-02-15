package com.ecommerce.cart.Dto;

import org.bson.types.Binary;


public class ImageDTO {

	  private String imageName;

	  private String imageType;

	  private String imagedata;

	public ImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageDTO(String imageName, String imageType, String imagedata) {
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

	public String getImagedata() {
		return imagedata;
	}

	public void setImagedata(String imagedata) {
		this.imagedata = imagedata;
	}

	@Override
	public String toString() {
		return "ImageDTO [imageName=" + imageName + ", imageType=" + imageType + ", imagedata=" + imagedata + "]";
	}

}
