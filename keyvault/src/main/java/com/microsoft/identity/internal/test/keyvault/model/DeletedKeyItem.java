/**
 * // Copyright (c) Microsoft Corporation.
 * // All rights reserved.
 * //
 * // This code is licensed under the MIT License.
 * //
 * // Permission is hereby granted, free of charge, to any person obtaining a copy
 * // of this software and associated documentation files(the "Software"), to deal
 * // in the Software without restriction, including without limitation the rights
 * // to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
 * // copies of the Software, and to permit persons to whom the Software is
 * // furnished to do so, subject to the following conditions :
 * //
 * // The above copyright notice and this permission notice shall be included in
 * // all copies or substantial portions of the Software.
 * //
 * // THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * // IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * // FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * // AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * // LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * // OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * // THE SOFTWARE.
 * */

/*
 * KeyVaultClient
 * The key vault client performs cryptographic key operations and vault operations against the Key Vault service.
 *
 * OpenAPI spec version: 2016-10-01
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.microsoft.identity.internal.test.keyvault.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * The deleted key item containing the deleted key metadata and information about deletion.
 */
@ApiModel(description = "The deleted key item containing the deleted key metadata and information about deletion.")

public class DeletedKeyItem {
  @SerializedName("kid")
  private String kid = null;

  @SerializedName("attributes")
  private KeyAttributes attributes = null;

  @SerializedName("tags")
  private Map<String, String> tags = null;

  @SerializedName("managed")
  private Boolean managed = null;

  public DeletedKeyItem kid(String kid) {
    this.kid = kid;
    return this;
  }

   /**
   * Key identifier.
   * @return kid
  **/
  @ApiModelProperty(value = "Key identifier.")
  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }

  public DeletedKeyItem attributes(KeyAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * The key management attributes.
   * @return attributes
  **/
  @ApiModelProperty(value = "The key management attributes.")
  public KeyAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(KeyAttributes attributes) {
    this.attributes = attributes;
  }

  public DeletedKeyItem tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  public DeletedKeyItem putTagsItem(String key, String tagsItem) {
    if (this.tags == null) {
      this.tags = new HashMap<String, String>();
    }
    this.tags.put(key, tagsItem);
    return this;
  }

   /**
   * Application specific metadata in the form of key-value pairs.
   * @return tags
  **/
  @ApiModelProperty(value = "Application specific metadata in the form of key-value pairs.")
  public Map<String, String> getTags() {
    return tags;
  }

  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

   /**
   * True if the key&#39;s lifetime is managed by key vault. If this is a key backing a certificate, then managed will be true.
   * @return managed
  **/
  @ApiModelProperty(value = "True if the key's lifetime is managed by key vault. If this is a key backing a certificate, then managed will be true.")
  public Boolean isManaged() {
    return managed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeletedKeyItem deletedKeyItem = (DeletedKeyItem) o;
    return Objects.equals(this.kid, deletedKeyItem.kid) &&
        Objects.equals(this.attributes, deletedKeyItem.attributes) &&
        Objects.equals(this.tags, deletedKeyItem.tags) &&
        Objects.equals(this.managed, deletedKeyItem.managed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kid, attributes, tags, managed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeletedKeyItem {\n");
    
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    managed: ").append(toIndentedString(managed)).append("\n");
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

