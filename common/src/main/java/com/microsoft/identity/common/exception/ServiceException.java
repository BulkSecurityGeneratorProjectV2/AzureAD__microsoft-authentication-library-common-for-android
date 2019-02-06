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
package com.microsoft.identity.common.exception;

import com.microsoft.identity.common.adal.internal.net.HttpWebResponse;
import com.microsoft.identity.common.adal.internal.util.HashMapExtensions;
import com.microsoft.identity.common.internal.net.HttpResponse;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;

public class ServiceException extends BaseException {

    /**
     * This request is missing a required parameter, includes an invalid parameter, includes a parameter more than
     * once, or is otherwise malformed.
     */
    public static final String INVALID_REQUEST = "invalid_request";

    /**
     * The client is not authorized to request an authorization code.
     */
    public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";

    /**
     * The resource owner or authorization server denied the request.
     */
    public static final String ACCESS_DENIED = "access_denied";

    /**
     * The request scope is invalid, unknown or malformed.
     */
    public static final String INVALID_SCOPE = "invalid_scope";

    /**
     * Represents 500/503/504 error codes.
     */
    public static final String SERVICE_NOT_AVAILABLE = "service_not_available";

    /**
     * Represents {@link java.net.SocketTimeoutException}.
     */
    public static final String REQUEST_TIMEOUT = "request_timeout";

    /**
     * AuthorityMetadata validation failed.
     */
    public static final String INVALID_INSTANCE = "invalid_instance";

    /**
     * Request to server failed, but no error and error_description is returned back from the service.
     */
    public static final String UNKNOWN_ERROR = "unknown_error";

    private int mHttpStatusCode;

    private HashMap<String, String> mHttpResponseBody = null;

    private HashMap<String, List<String>> mHttpResponseHeaders = null;

    private String mOAuthError;

    private String mOAuthErrorDescription;

    /**
     * When {@link java.net.SocketTimeoutException} is thrown, no status code will be caught. Will use 0 instead.
     */
    public static final int DEFAULT_STATUS_CODE = 0;

    /**
     * @return The http status code for the request sent to the service.
     */
    public int getHttpStatusCode() {
        return mHttpStatusCode;
    }

    /**
     * Gets the response body that may be returned by the service.
     *
     * @return response body map, null if not initialized.
     */
    public HashMap<String, String> getHttpResponseBody() {
        return mHttpResponseBody;
    }

    /**
     * Get the response headers that indicated an error.
     *
     * @return The response headers for the network call, null if not initialized.
     */
    public HashMap<String, List<String>> getHttpResponseHeaders() {
        return mHttpResponseHeaders;
    }

    /**
     * Set the http response {@link HttpWebResponse}.
     *
     * @param response HttpWebResponse
     */
    public void setHttpResponse(final HttpResponse response) throws JSONException {
        if (null != response) {
            mHttpStatusCode = response.getStatusCode();

            if (null != response.getHeaders()) {
                mHttpResponseHeaders = new HashMap<>(response.getHeaders());
            }

            if (null != response.getBody()) {
                    mHttpResponseBody = new HashMap<>(HashMapExtensions.getJsonResponse(response));
            }
        }
    }

    /**
     * Constructor of ServiceException.
     *
     * @param errorCode    String
     * @param errorMessage String
     * @param throwable    Throwable
     */
    public ServiceException(final String errorCode, final String errorMessage, final Throwable throwable) {
        super(errorCode, errorMessage, throwable);
        mHttpStatusCode = DEFAULT_STATUS_CODE;
    }

    /**
     * Constructor of ServiceException.
     *
     * @param errorCode      String
     * @param errorMessage   String
     * @param httpStatusCode int
     * @param throwable      Throwable
     */
    public ServiceException(final String errorCode, final String errorMessage, final int httpStatusCode, final Throwable throwable) {
        super(errorCode, errorMessage, throwable);
        mHttpStatusCode = httpStatusCode;
    }

    public String getOAuthError() {
        return mOAuthError;
    }

    public void setOAuthError(final String oAuthError) {
        this.mOAuthError = oAuthError;
    }

    public String getOAuthErrorDescription() {
        return mOAuthErrorDescription;
    }

    public void setOAuthErrorDescription(final String oAuthErrorDescription) {
        this.mOAuthErrorDescription = oAuthErrorDescription;
    }
}
