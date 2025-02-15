package com.ecommerce.user.model;

import java.util.Objects;
import com.ecommerce.user.model.AdminResponseResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AdminResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T18:09:09.537264300+05:30[Asia/Calcutta]")

public class AdminResponse   {
  @JsonProperty("statusCode")
  private Integer statusCode;

  @JsonProperty("statusMessage")
  private String statusMessage;

  @JsonProperty("result")
  @Valid
  private List<AdminResponseResult> result = null;

  public AdminResponse statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  */
  @ApiModelProperty(example = "200", value = "")


  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public AdminResponse statusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return this;
  }

  /**
   * Get statusMessage
   * @return statusMessage
  */
  @ApiModelProperty(example = "Operation completed successful", value = "")


  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public AdminResponse result(List<AdminResponseResult> result) {
    this.result = result;
    return this;
  }

  public AdminResponse addResultItem(AdminResponseResult resultItem) {
    if (this.result == null) {
      this.result = new ArrayList<>();
    }
    this.result.add(resultItem);
    return this;
  }

  /**
   * Get result
   * @return result
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<AdminResponseResult> getResult() {
    return result;
  }

  public void setResult(List<AdminResponseResult> result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminResponse adminResponse = (AdminResponse) o;
    return Objects.equals(this.statusCode, adminResponse.statusCode) &&
        Objects.equals(this.statusMessage, adminResponse.statusMessage) &&
        Objects.equals(this.result, adminResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusMessage, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

