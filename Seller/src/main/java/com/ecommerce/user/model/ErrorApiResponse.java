package com.ecommerce.user.model;

import java.util.Objects;
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
 * ErrorApiResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T18:09:09.537264300+05:30[Asia/Calcutta]")

public class ErrorApiResponse   {
  @JsonProperty("errorMessages")
  @Valid
  private List<String> errorMessages = null;

  @JsonProperty("statusCode")
  private Integer statusCode;

  @JsonProperty("statusMessage")
  private String statusMessage;

  public ErrorApiResponse errorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
    return this;
  }

  public ErrorApiResponse addErrorMessagesItem(String errorMessagesItem) {
    if (this.errorMessages == null) {
      this.errorMessages = new ArrayList<>();
    }
    this.errorMessages.add(errorMessagesItem);
    return this;
  }

  /**
   * Get errorMessages
   * @return errorMessages
  */
  @ApiModelProperty(value = "")


  public List<String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public ErrorApiResponse statusCode(Integer statusCode) {
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

  public ErrorApiResponse statusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return this;
  }

  /**
   * Get statusMessage
   * @return statusMessage
  */
  @ApiModelProperty(value = "")


  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorApiResponse errorApiResponse = (ErrorApiResponse) o;
    return Objects.equals(this.errorMessages, errorApiResponse.errorMessages) &&
        Objects.equals(this.statusCode, errorApiResponse.statusCode) &&
        Objects.equals(this.statusMessage, errorApiResponse.statusMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessages, statusCode, statusMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorApiResponse {\n");
    
    sb.append("    errorMessages: ").append(toIndentedString(errorMessages)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
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

