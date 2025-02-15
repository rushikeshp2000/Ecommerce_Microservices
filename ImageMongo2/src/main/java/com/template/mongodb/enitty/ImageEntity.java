package com.template.mongodb.enitty;

import org.bson.types.Binary;
import org.springframework.core.io.Resource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageEntity {

	private String id;
	
	private String imageName;
	
	private String imageType;

	 private Binary imagedata;

	public ImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ImageEntity(String id, String imageName, String imageType, Binary imagedata) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imagedata = imagedata;
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", imageName=" + imageName + ", imageType=" + imageType + ", imagedata="
				+ imagedata + "]";
	}

	
	 
	 
}
