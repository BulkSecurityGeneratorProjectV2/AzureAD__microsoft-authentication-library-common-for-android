// Copyright (c) Microsoft Corporation.
// All rights reserved.
//
// This code is licensed under the MIT License.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.microsoft.identity.common.internal.dto;

import com.google.gson.annotations.SerializedName;

import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.CACHED_AT;
import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.CLIENT_ID;
import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.CREDENTIAL_TYPE;
import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.ENVIRONMENT;
import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.EXPIRES_ON;
import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.SECRET;
import static com.microsoft.identity.common.internal.dto.Credential.SerializedNames.UNIQUE_USER_ID;

/**
 * This is a generic credential schema that should be used as a reference to define schemas for
 * specific credential types.
 */
public abstract class Credential extends AccountCredentialBase {

    public static class SerializedNames {
        public static final String CLIENT_ID = "client_id";
        public static final String CREDENTIAL_TYPE = "credential_type";
        public static final String ENVIRONMENT = "environment";
        public static final String SECRET = "secret";
        public static final String UNIQUE_USER_ID = "unique_user_id";
        public static final String CACHED_AT = "cached_at";
        public static final String EXPIRES_ON = "expires_on";
    }

    /**
     * The client id of application, as defined in the app developer portal.
     */
    @SerializedName(CLIENT_ID)
    private String mClientId;

    /**
     * A designated {@link CredentialType} represnted as a String.
     */
    @SerializedName(CREDENTIAL_TYPE)
    private String mCredentialType;

    /**
     * Entity who issued the token represented as a full host of it. For AAD it's host part from
     * the authority url with an optional port. For ADFS, it's the host part of the ADFS server URL.
     */
    @SerializedName(ENVIRONMENT)
    private String mEnvironment;

    /**
     * The credential as a String.
     */
    @SerializedName(SECRET)
    private String mSecret;

    /**
     * Unique user identifier for that authentication scheme.  
     * <p>
     * For AAD/MSA: <code><uid>.<utid></code> <br />
     * STS returns the clientInfo on both v1 and v2 for AAD. This value is combined from two fields
     * in the client Info. It should be a unique user identifier across tenants (e.g. the value will
     * be the same for user’s home tenant and a guest tenant). 
     * </p>
     * <p>
     * For NTLM: Canonicalized username
     * </p>
     * This field is optional if there's no user present for the flow (e.g. client credential
     * grants)
     */
    @SerializedName(UNIQUE_USER_ID)
    private String mUniqueId;

    /**
     * Absolute device time when entry was created in cache in milliseconds from epoch (1970).
     */
    @SerializedName(CACHED_AT)
    private String mCachedAt;

    /**
     * Token expiry time. This value should be calculated based on the current UTC time measured
     * locally and the value expires_in returned from the service. Measured in milliseconds from
     * epoch (1970).
     */
    @SerializedName(EXPIRES_ON)
    private String mExpiresOn;

    /**
     * Gets the unique_user_id.
     *
     * @return The unique_user_id to get.
     */
    public String getUniqueUserId() {
        return mUniqueId;
    }

    /**
     * Sets the unique_user_id.
     *
     * @param uniqueId The unique_user_id to set.
     */
    public void setUniqueUserId(final String uniqueId) {
        mUniqueId = uniqueId;
    }

    /**
     * Gets the environment.
     *
     * @return The environment to get.
     */
    public String getEnvironment() {
        return mEnvironment;
    }

    /**
     * Sets the environment.
     *
     * @param environment The environment to set.
     */
    public void setEnvironment(final String environment) {
        mEnvironment = environment;
    }

    /**
     * Gets the credential_type.
     *
     * @return The credential_type to get.
     */
    public String getCredentialType() {
        return mCredentialType;
    }

    /**
     * Sets the credential_type.
     *
     * @param credentialType The credential_type to set.
     */
    public void setCredentialType(final String credentialType) {
        mCredentialType = credentialType;
    }

    /**
     * Gets the client_id.
     *
     * @return The client_id to get.
     */
    public String getClientId() {
        return mClientId;
    }

    /**
     * Sets the client_id.
     *
     * @param clientId The client_id to set.
     */
    public void setClientId(final String clientId) {
        mClientId = clientId;
    }

    /**
     * Gets the secret.
     *
     * @return The secret to get.
     */
    public String getSecret() {
        return mSecret;
    }

    /**
     * Sets the secret.
     *
     * @param secret The secret to set.
     */
    public void setSecret(final String secret) {
        mSecret = secret;
    }

    /**
     * Gets the cached_at.
     *
     * @return The cached_at to get.
     */
    public String getCachedAt() {
        return mCachedAt;
    }

    /**
     * Sets the cached_at.
     *
     * @param cachedAt The cached_at to set.
     */
    public void setCachedAt(final String cachedAt) {
        mCachedAt = cachedAt;
    }

    /**
     * Gets the expires_on.
     *
     * @return The expires_on to get.
     */
    public String getExpiresOn() {
        return mExpiresOn;
    }

    /**
     * Sets the expires_on.
     *
     * @param expiresOn The expires_on to set.
     */
    public void setExpiresOn(final String expiresOn) {
        mExpiresOn = expiresOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credential that = (Credential) o;

        if (mClientId != null ? !mClientId.equals(that.mClientId) : that.mClientId != null)
            return false;
        if (mCredentialType != null ? !mCredentialType.equals(that.mCredentialType) : that.mCredentialType != null)
            return false;
        if (mEnvironment != null ? !mEnvironment.equals(that.mEnvironment) : that.mEnvironment != null)
            return false;
        if (mSecret != null ? !mSecret.equals(that.mSecret) : that.mSecret != null) return false;
        if (mUniqueId != null ? !mUniqueId.equals(that.mUniqueId) : that.mUniqueId != null)
            return false;
        if (mCachedAt != null ? !mCachedAt.equals(that.mCachedAt) : that.mCachedAt != null)
            return false;
        return mExpiresOn != null ? mExpiresOn.equals(that.mExpiresOn) : that.mExpiresOn == null;
    }

    @Override
    public int hashCode() {
        int result = mClientId != null ? mClientId.hashCode() : 0;
        result = 31 * result + (mCredentialType != null ? mCredentialType.hashCode() : 0);
        result = 31 * result + (mEnvironment != null ? mEnvironment.hashCode() : 0);
        result = 31 * result + (mSecret != null ? mSecret.hashCode() : 0);
        result = 31 * result + (mUniqueId != null ? mUniqueId.hashCode() : 0);
        result = 31 * result + (mCachedAt != null ? mCachedAt.hashCode() : 0);
        result = 31 * result + (mExpiresOn != null ? mExpiresOn.hashCode() : 0);
        return result;
    }
}
