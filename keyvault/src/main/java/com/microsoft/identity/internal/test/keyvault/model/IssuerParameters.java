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

/**
 * Parameters for the issuer of the X509 component of a certificate.
 */
@ApiModel(description = "Parameters for the issuer of the X509 component of a certificate.")
public class IssuerParameters {
  @SerializedName("name")
  private String name = null;

  @SerializedName("cty")
  private String cty = null;

  public IssuerParameters name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the referenced issuer object or reserved names; for example, &#39;Self&#39; or &#39;Unknown&#39;.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the referenced issuer object or reserved names; for example, 'Self' or 'Unknown'.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IssuerParameters cty(String cty) {
    this.cty = cty;
    return this;
  }

   /**
   * Type of certificate to be requested from the issuer provider.
   * @return cty
  **/
  @ApiModelProperty(value = "Type of certificate to be requested from the issuer provider.")
  public String getCty() {
    return cty;
  }

  public void setCty(String cty) {
    this.cty = cty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssuerParameters issuerParameters = (IssuerParameters) o;
    return Objects.equals(this.name, issuerParameters.name) &&
        Objects.equals(this.cty, issuerParameters.cty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cty);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssuerParameters {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cty: ").append(toIndentedString(cty)).append("\n");
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

