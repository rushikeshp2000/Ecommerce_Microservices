package com.ecommerce.productService.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.core.io.Resource;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is the product object model
 */
@ApiModel(description = "This is the product object model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-30T15:51:39.511425500+05:30[Asia/Calcutta]")

public class Product   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("imagefile1")
  private Resource imagefile1;

  @JsonProperty("imagefile2")
  private Resource imagefile2;

  @JsonProperty("imagefile3")
  private Resource imagefile3;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("details")
  private String details;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("sellerNumber")
  private UUID sellerNumber;

  @JsonProperty("category")
  private String category;

  @JsonProperty("discount")
  private Integer discount;

  public Product name(String name) {
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

  public Product imagefile1(Resource imagefile1) {
    this.imagefile1 = imagefile1;
    return this;
  }

  /**
   * Get imagefile1
   * @return imagefile1
  */
  @ApiModelProperty(value = "")

  @Valid

  public Resource getImagefile1() {
    return imagefile1;
  }

  public void setImagefile1(Resource imagefile1) {
    this.imagefile1 = imagefile1;
  }

  public Product imagefile2(Resource imagefile2) {
    this.imagefile2 = imagefile2;
    return this;
  }

  /**
   * Get imagefile2
   * @return imagefile2
  */
  @ApiModelProperty(value = "")

  @Valid

  public Resource getImagefile2() {
    return imagefile2;
  }

  public void setImagefile2(Resource imagefile2) {
    this.imagefile2 = imagefile2;
  }

  public Product imagefile3(Resource imagefile3) {
    this.imagefile3 = imagefile3;
    return this;
  }

  /**
   * Get imagefile3
   * @return imagefile3
  */
  @ApiModelProperty(value = "")

  @Valid

  public Resource getImagefile3() {
    return imagefile3;
  }

  public void setImagefile3(Resource imagefile3) {
    this.imagefile3 = imagefile3;
  }

  public Product price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(example = "12.25", value = "")

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Product details(String details) {
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

  public Product quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @ApiModelProperty(example = "10", value = "")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Product sellerNumber(UUID sellerNumber) {
    this.sellerNumber = sellerNumber;
    return this;
  }

  /**
   * Get sellerNumber
   * @return sellerNumber
  */
  @ApiModelProperty(example = "ae04a3db-8169-4f91-95f9-478bdb107840", value = "")

  @Valid

  public UUID getSellerNumber() {
    return sellerNumber;
  }

  public void setSellerNumber(UUID sellerNumber) {
    this.sellerNumber = sellerNumber;
  }

  public Product category(String category) {
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

  public Product discount(Integer discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
  */
  @ApiModelProperty(example = "20", value = "")


  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.name, product.name) &&
        Objects.equals(this.imagefile1, product.imagefile1) &&
        Objects.equals(this.imagefile2, product.imagefile2) &&
        Objects.equals(this.imagefile3, product.imagefile3) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.details, product.details) &&
        Objects.equals(this.quantity, product.quantity) &&
        Objects.equals(this.sellerNumber, product.sellerNumber) &&
        Objects.equals(this.category, product.category) &&
        Objects.equals(this.discount, product.discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, imagefile1, imagefile2, imagefile3, price, details, quantity, sellerNumber, category, discount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    imagefile1: ").append(toIndentedString(imagefile1)).append("\n");
    sb.append("    imagefile2: ").append(toIndentedString(imagefile2)).append("\n");
    sb.append("    imagefile3: ").append(toIndentedString(imagefile3)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    sellerNumber: ").append(toIndentedString(sellerNumber)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
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

