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
 * InlineObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-06T12:53:04.262702700+05:30[Asia/Calcutta]")

public class InlineObject   {
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

  @JsonProperty("images")
  @Valid
  private List<Resource> images = null;

  public InlineObject name(String name) {
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

  public InlineObject price(String price) {
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

  public InlineObject details(String details) {
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

  public InlineObject quantity(String quantity) {
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

  public InlineObject sellerNumber(String sellerNumber) {
    this.sellerNumber = sellerNumber;
    return this;
  }

  /**
   * Get sellerNumber
   * @return sellerNumber
  */
  @ApiModelProperty(example = "ae04a3db-8169-4f91-95f9-478bdb107840", value = "")


  public String getSellerNumber() {
    return sellerNumber;
  }

  public void setSellerNumber(String sellerNumber) {
    this.sellerNumber = sellerNumber;
  }

  public InlineObject category(String category) {
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

  public InlineObject discount(String discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
  */
  @ApiModelProperty(example = "20", value = "")


  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public InlineObject images(List<Resource> images) {
    this.images = images;
    return this;
  }

  public InlineObject addImagesItem(Resource imagesItem) {
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
    InlineObject inlineObject = (InlineObject) o;
    return Objects.equals(this.name, inlineObject.name) &&
        Objects.equals(this.price, inlineObject.price) &&
        Objects.equals(this.details, inlineObject.details) &&
        Objects.equals(this.quantity, inlineObject.quantity) &&
        Objects.equals(this.sellerNumber, inlineObject.sellerNumber) &&
        Objects.equals(this.category, inlineObject.category) &&
        Objects.equals(this.discount, inlineObject.discount) &&
        Objects.equals(this.images, inlineObject.images);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, details, quantity, sellerNumber, category, discount, images);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    sellerNumber: ").append(toIndentedString(sellerNumber)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
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

