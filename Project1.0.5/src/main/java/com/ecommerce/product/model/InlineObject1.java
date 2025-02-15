package com.ecommerce.product.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineObject1
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T19:35:05.706628+05:30[Asia/Calcutta]")

public class InlineObject1   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private String price;

  @JsonProperty("details")
  private String details;

  @JsonProperty("quantity")
  private String quantity;

  @JsonProperty("sellerNumber")
  private String sellerNumber;

  @JsonProperty("category")
  private String category;

  @JsonProperty("discount")
  private String discount;

  @JsonProperty("status")
  private String status;

  @JsonProperty("images")
  @Valid
  private List<Resource> images = null;

  public InlineObject1 name(String name) {
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

  public InlineObject1 price(String price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(example = "12.25", value = "")


  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public InlineObject1 details(String details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
  */
  @ApiModelProperty(example = "description of the image that we want to show", value = "")


  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public InlineObject1 quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @ApiModelProperty(example = "10", value = "")


  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public InlineObject1 sellerNumber(String sellerNumber) {
    this.sellerNumber = sellerNumber;
    return this;
  }

  /**
   * Get sellerNumber
   * @return sellerNumber
  */
  @ApiModelProperty(value = "")


  public String getSellerNumber() {
    return sellerNumber;
  }

  public void setSellerNumber(String sellerNumber) {
    this.sellerNumber = sellerNumber;
  }

  public InlineObject1 category(String category) {
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

  public InlineObject1 discount(String discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
  */
  @ApiModelProperty(value = "")


  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public InlineObject1 status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public InlineObject1 images(List<Resource> images) {
    this.images = images;
    return this;
  }

  public InlineObject1 addImagesItem(Resource imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<>();
    }
    this.images.add(imagesItem);
    return this;
  }

  /**
   * Get images
   * @return images
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Resource> getImages() {
    return images;
  }

  public void setImages(List<Resource> images) {
    this.images = images;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject1 inlineObject1 = (InlineObject1) o;
    return Objects.equals(this.name, inlineObject1.name) &&
        Objects.equals(this.price, inlineObject1.price) &&
        Objects.equals(this.details, inlineObject1.details) &&
        Objects.equals(this.quantity, inlineObject1.quantity) &&
        Objects.equals(this.sellerNumber, inlineObject1.sellerNumber) &&
        Objects.equals(this.category, inlineObject1.category) &&
        Objects.equals(this.discount, inlineObject1.discount) &&
        Objects.equals(this.status, inlineObject1.status) &&
        Objects.equals(this.images, inlineObject1.images);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, details, quantity, sellerNumber, category, discount, status, images);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject1 {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    sellerNumber: ").append(toIndentedString(sellerNumber)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
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

