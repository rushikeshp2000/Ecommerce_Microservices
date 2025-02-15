package com.template.mongodb.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.template.mongodb.model.ImageModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is the product object model
 */
@ApiModel(description = "This is the product object model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-04T17:02:42.150979100+05:30[Asia/Calcutta]")

public class ProductPost   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("category")
  private String category;

  @JsonProperty("image")
  @Valid
  private List<ImageModel> image = null;

  public ProductPost name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "shoes", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductPost category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @ApiModelProperty(example = "hardware", value = "")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ProductPost image(List<ImageModel> image) {
    this.image = image;
    return this;
  }

  public ProductPost addImageItem(ImageModel imageItem) {
    if (this.image == null) {
      this.image = new ArrayList<>();
    }
    this.image.add(imageItem);
    return this;
  }

  /**
   * Get image
   * @return image
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ImageModel> getImage() {
    return image;
  }

  public void setImage(List<ImageModel> image) {
    this.image = image;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductPost productPost = (ProductPost) o;
    return Objects.equals(this.name, productPost.name) &&
        Objects.equals(this.category, productPost.category) &&
        Objects.equals(this.image, productPost.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, category, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPost {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

