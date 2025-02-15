package com.ecommerce.order.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderResults
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-15T02:17:57.182843300+05:30[Asia/Calcutta]")

public class OrderResults   {
  @JsonProperty("orderId")
  private String orderId;

  @JsonProperty("UserId")
  private String userId;

  @JsonProperty("SellerId")
  private String sellerId;

  @JsonProperty("UserName")
  private String userName;

  @JsonProperty("UserAddress")
  private String userAddress;

  @JsonProperty("UserPhone")
  private String userPhone;

  @JsonProperty("UserEmail")
  private String userEmail;

  @JsonProperty("ProductName")
  private String productName;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("Totalprice")
  private Double totalprice;

  @JsonProperty("createdBy")
  private String createdBy;

  @JsonProperty("createdDate")
  private String createdDate;

  @JsonProperty("updateDate")
  private String updateDate;

  public OrderResults orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  @ApiModelProperty(value = "")


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public OrderResults userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public OrderResults sellerId(String sellerId) {
    this.sellerId = sellerId;
    return this;
  }

  /**
   * Get sellerId
   * @return sellerId
  */
  @ApiModelProperty(value = "")


  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }

  public OrderResults userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  @ApiModelProperty(value = "")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public OrderResults userAddress(String userAddress) {
    this.userAddress = userAddress;
    return this;
  }

  /**
   * Get userAddress
   * @return userAddress
  */
  @ApiModelProperty(value = "")


  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public OrderResults userPhone(String userPhone) {
    this.userPhone = userPhone;
    return this;
  }

  /**
   * Get userPhone
   * @return userPhone
  */
  @ApiModelProperty(value = "")


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public OrderResults userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * Get userEmail
   * @return userEmail
  */
  @ApiModelProperty(value = "")


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public OrderResults productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Get productName
   * @return productName
  */
  @ApiModelProperty(value = "")


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public OrderResults price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public OrderResults quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @ApiModelProperty(value = "")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderResults totalprice(Double totalprice) {
    this.totalprice = totalprice;
    return this;
  }

  /**
   * Get totalprice
   * @return totalprice
  */
  @ApiModelProperty(value = "")


  public Double getTotalprice() {
    return totalprice;
  }

  public void setTotalprice(Double totalprice) {
    this.totalprice = totalprice;
  }

  public OrderResults createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
  */
  @ApiModelProperty(value = "")


  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public OrderResults createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  */
  @ApiModelProperty(value = "")


  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public OrderResults updateDate(String updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  /**
   * Get updateDate
   * @return updateDate
  */
  @ApiModelProperty(value = "")


  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderResults orderResults = (OrderResults) o;
    return Objects.equals(this.orderId, orderResults.orderId) &&
        Objects.equals(this.userId, orderResults.userId) &&
        Objects.equals(this.sellerId, orderResults.sellerId) &&
        Objects.equals(this.userName, orderResults.userName) &&
        Objects.equals(this.userAddress, orderResults.userAddress) &&
        Objects.equals(this.userPhone, orderResults.userPhone) &&
        Objects.equals(this.userEmail, orderResults.userEmail) &&
        Objects.equals(this.productName, orderResults.productName) &&
        Objects.equals(this.price, orderResults.price) &&
        Objects.equals(this.quantity, orderResults.quantity) &&
        Objects.equals(this.totalprice, orderResults.totalprice) &&
        Objects.equals(this.createdBy, orderResults.createdBy) &&
        Objects.equals(this.createdDate, orderResults.createdDate) &&
        Objects.equals(this.updateDate, orderResults.updateDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, userId, sellerId, userName, userAddress, userPhone, userEmail, productName, price, quantity, totalprice, createdBy, createdDate, updateDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderResults {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    sellerId: ").append(toIndentedString(sellerId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    userAddress: ").append(toIndentedString(userAddress)).append("\n");
    sb.append("    userPhone: ").append(toIndentedString(userPhone)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    totalprice: ").append(toIndentedString(totalprice)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    updateDate: ").append(toIndentedString(updateDate)).append("\n");
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

