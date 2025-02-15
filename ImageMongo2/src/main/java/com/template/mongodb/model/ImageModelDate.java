package com.template.mongodb.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is the image model
 */
@ApiModel(description = "This is the image model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-04T18:27:18.358939100+05:30[Asia/Calcutta]")

public class ImageModelDate   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("imageName")
  private String imageName;

  @JsonProperty("imageType")
  private String imageType;

  @JsonProperty("imagedata")
  private String imagedata;

  public ImageModelDate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ImageModelDate imageName(String imageName) {
    this.imageName = imageName;
    return this;
  }

  /**
   * Get imageName
   * @return imageName
  */
  @ApiModelProperty(example = "image", value = "")


  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public ImageModelDate imageType(String imageType) {
    this.imageType = imageType;
    return this;
  }

  /**
   * Get imageType
   * @return imageType
  */
  @ApiModelProperty(example = "jpeg", value = "")


  public String getImageType() {
    return imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  public ImageModelDate imagedata(String imagedata) {
    this.imagedata = imagedata;
    return this;
  }

  /**
   * Get imagedata
   * @return imagedata
  */
  @ApiModelProperty(value = "")


  public String getImagedata() {
    return imagedata;
  }

  public void setImagedata(String imagedata) {
    this.imagedata = imagedata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageModelDate imageModelDate = (ImageModelDate) o;
    return Objects.equals(this.id, imageModelDate.id) &&
        Objects.equals(this.imageName, imageModelDate.imageName) &&
        Objects.equals(this.imageType, imageModelDate.imageType) &&
        Objects.equals(this.imagedata, imageModelDate.imagedata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, imageName, imageType, imagedata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageModelDate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    imageName: ").append(toIndentedString(imageName)).append("\n");
    sb.append("    imageType: ").append(toIndentedString(imageType)).append("\n");
    sb.append("    imagedata: ").append(toIndentedString(imagedata)).append("\n");
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

