package com.template.mongodb.enitty;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document("mongoImageTwo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductEntity {

	@Id
	private String id;
	
	private String name;
	
	private String category;
	
	private List<ImageEntity> image;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(String id, String name, String category, List<ImageEntity> image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ImageEntity> getImage() {
		return image;
	}

	public void setImage(List<ImageEntity> image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", category=" + category + ", image=" + image + "]";
	}
	
	

	
	
}
