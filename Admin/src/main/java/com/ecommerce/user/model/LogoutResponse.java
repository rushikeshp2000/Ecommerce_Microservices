package com.ecommerce.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LogoutResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-06T18:36:06.059763800+05:30[Asia/Calcutta]")

public class LogoutResponse   {
  @JsonProperty("messaage")
  private String messaage;

  @JsonProperty("statusCode")
  private Integer statusCode;

  public LogoutResponse messaage(String messaage) {
    this.messaage = messaage;
    return this;
  }

  /**
   * Get messaage
   * @return messaage
  */
  @ApiModelProperty(value = "")


  public String getMessaage() {
    return messaage;
  }

  public void setMessaage(String messaage) {
    this.messaage = messaage;
  }

  public LogoutResponse statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  */
  @ApiModelProperty(value = "")


  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogoutResponse logoutResponse = (LogoutResponse) o;
    return Objects.equals(this.messaage, logoutResponse.messaage) &&
        Objects.equals(this.statusCode, logoutResponse.statusCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messaage, statusCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogoutResponse {\n");
    
    sb.append("    messaage: ").append(toIndentedString(messaage)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

