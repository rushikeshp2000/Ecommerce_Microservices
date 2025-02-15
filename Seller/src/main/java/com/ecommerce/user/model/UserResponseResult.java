package com.ecommerce.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserResponseResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T18:09:09.537264300+05:30[Asia/Calcutta]")

public class UserResponseResult   {
  @JsonProperty("sellerid")
  private String sellerid;

  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private String address;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private BigDecimal phone;

  public UserResponseResult sellerid(String sellerid) {
    this.sellerid = sellerid;
    return this;
  }

  /**
   * Get sellerid
   * @return sellerid
  */
  @ApiModelProperty(value = "")


  public String getSellerid() {
    return sellerid;
  }

  public void setSellerid(String sellerid) {
    this.sellerid = sellerid;
  }

  public UserResponseResult name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "John", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserResponseResult address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(example = "James", value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserResponseResult email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(example = "john@email.com", value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserResponseResult phone(BigDecimal phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @ApiModelProperty(example = "9855455", value = "")

  @Valid

  public BigDecimal getPhone() {
    return phone;
  }

  public void setPhone(BigDecimal phone) {
    this.phone = phone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserResponseResult userResponseResult = (UserResponseResult) o;
    return Objects.equals(this.sellerid, userResponseResult.sellerid) &&
        Objects.equals(this.name, userResponseResult.name) &&
        Objects.equals(this.address, userResponseResult.address) &&
        Objects.equals(this.email, userResponseResult.email) &&
        Objects.equals(this.phone, userResponseResult.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sellerid, name, address, email, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResponseResult {\n");
    
    sb.append("    sellerid: ").append(toIndentedString(sellerid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

