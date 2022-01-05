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
 * Azure Identity Labs API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.microsoft.identity.internal.test.labapi.api;

import com.microsoft.identity.internal.test.labapi.ApiCallback;
import com.microsoft.identity.internal.test.labapi.ApiClient;
import com.microsoft.identity.internal.test.labapi.ApiException;
import com.microsoft.identity.internal.test.labapi.ApiResponse;
import com.microsoft.identity.internal.test.labapi.Configuration;
import com.microsoft.identity.internal.test.labapi.Pair;
import com.microsoft.identity.internal.test.labapi.ProgressRequestBody;
import com.microsoft.identity.internal.test.labapi.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.microsoft.identity.internal.test.labapi.model.CustomErrorResponse;
import com.microsoft.identity.internal.test.labapi.model.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient apiClient;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for apiUserGet
     * @param usertype Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param userrole Allowed Values :  \&quot;none\&quot;, \&quot;clouddeviceadministrator\&quot; (optional, default to none)
     * @param mfa Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;truemamca\&quot;,\&quot;mamspo\&quot;, \&quot;blocked\&quot; (optional, default to none)
     * @param homedomain Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;none\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to adfsv4)
     * @param azureenvironment Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param guesthomeazureenvironment Allowed Values :  \&quot;none\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azureusgovernment\&quot; (optional, default to none)
     * @param apptype Allowed Values :  \&quot;cloud\&quot;, \&quot;onprem\&quot; (optional, default to cloud)
     * @param publicclient Allowed Values :  \&quot;yes\&quot;, \&quot;no\&quot; (optional, default to yes)
     * @param signinaudience Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @param guesthomedin Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot;, \&quot;hostazuread\&quot; (optional, default to none)
     * @param hasaltid Allowed Values :  \&quot;no\&quot;, \&quot;yes\&quot; (optional, default to no)
     * @param altidsource Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot; (optional, default to none)
     * @param altidtype Allowed Values :  \&quot;none\&quot;, \&quot;upn\&quot; (optional, default to none)
     * @param passwordpolicyvalidityperiod Allowed Values :  \&quot;60\&quot; (optional, default to 60)
     * @param passwordpolicynotificationdays Allowed Values :  \&quot;14\&quot;, \&quot;61\&quot; (optional, default to 14)
     * @param tokenlifetimepolicy Allowed Values :  \&quot;OrganizationDefault\&quot;, \&quot;CAE\&quot;, \&quot;CTL\&quot; (optional, default to OrganizationDefault)
     * @param tokentype Allowed Values :  \&quot;Access\&quot; (optional, default to Access)
     * @param tokenlifetime Allowed Values :  \&quot;default\&quot;, \&quot;short\&quot;, \&quot;long\&quot; (optional, default to default)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiUserGetCall(String usertype, String userrole, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String guesthomeazureenvironment, String apptype, String publicclient, String signinaudience, String guesthomedin, String hasaltid, String altidsource, String altidtype, String passwordpolicyvalidityperiod, String passwordpolicynotificationdays, String tokenlifetimepolicy, String tokentype, String tokenlifetime, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/User";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (usertype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("usertype", usertype));
        if (userrole != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("userrole", userrole));
        if (mfa != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("mfa", mfa));
        if (protectionpolicy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("protectionpolicy", protectionpolicy));
        if (homedomain != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("homedomain", homedomain));
        if (homeupn != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("homeupn", homeupn));
        if (b2cprovider != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("b2cprovider", b2cprovider));
        if (federationprovider != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("federationprovider", federationprovider));
        if (azureenvironment != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("azureenvironment", azureenvironment));
        if (guesthomeazureenvironment != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("guesthomeazureenvironment", guesthomeazureenvironment));
        if (apptype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("apptype", apptype));
        if (publicclient != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("publicclient", publicclient));
        if (signinaudience != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("signinaudience", signinaudience));
        if (guesthomedin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("guesthomedin", guesthomedin));
        if (hasaltid != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("hasaltid", hasaltid));
        if (altidsource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("altidsource", altidsource));
        if (altidtype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("altidtype", altidtype));
        if (passwordpolicyvalidityperiod != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("passwordpolicyvalidityperiod", passwordpolicyvalidityperiod));
        if (passwordpolicynotificationdays != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("passwordpolicynotificationdays", passwordpolicynotificationdays));
        if (tokenlifetimepolicy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tokenlifetimepolicy", tokenlifetimepolicy));
        if (tokentype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tokentype", tokentype));
        if (tokenlifetime != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tokenlifetime", tokenlifetime));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiUserGetValidateBeforeCall(String usertype, String userrole, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String guesthomeazureenvironment, String apptype, String publicclient, String signinaudience, String guesthomedin, String hasaltid, String altidsource, String altidtype, String passwordpolicyvalidityperiod, String passwordpolicynotificationdays, String tokenlifetimepolicy, String tokentype, String tokenlifetime, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = apiUserGetCall(usertype, userrole, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, guesthomeazureenvironment, apptype, publicclient, signinaudience, guesthomedin, hasaltid, altidsource, altidtype, passwordpolicyvalidityperiod, passwordpolicynotificationdays, tokenlifetimepolicy, tokentype, tokenlifetime, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Gets the Lab User(s) Based on Query Parameters with predefined defaults.   You can override the defaults.
     * 
     * @param usertype Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param userrole Allowed Values :  \&quot;none\&quot;, \&quot;clouddeviceadministrator\&quot; (optional, default to none)
     * @param mfa Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;truemamca\&quot;,\&quot;mamspo\&quot;, \&quot;blocked\&quot; (optional, default to none)
     * @param homedomain Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;none\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to adfsv4)
     * @param azureenvironment Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param guesthomeazureenvironment Allowed Values :  \&quot;none\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azureusgovernment\&quot; (optional, default to none)
     * @param apptype Allowed Values :  \&quot;cloud\&quot;, \&quot;onprem\&quot; (optional, default to cloud)
     * @param publicclient Allowed Values :  \&quot;yes\&quot;, \&quot;no\&quot; (optional, default to yes)
     * @param signinaudience Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @param guesthomedin Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot;, \&quot;hostazuread\&quot; (optional, default to none)
     * @param hasaltid Allowed Values :  \&quot;no\&quot;, \&quot;yes\&quot; (optional, default to no)
     * @param altidsource Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot; (optional, default to none)
     * @param altidtype Allowed Values :  \&quot;none\&quot;, \&quot;upn\&quot; (optional, default to none)
     * @param passwordpolicyvalidityperiod Allowed Values :  \&quot;60\&quot; (optional, default to 60)
     * @param passwordpolicynotificationdays Allowed Values :  \&quot;14\&quot;, \&quot;61\&quot; (optional, default to 14)
     * @param tokenlifetimepolicy Allowed Values :  \&quot;OrganizationDefault\&quot;, \&quot;CAE\&quot;, \&quot;CTL\&quot; (optional, default to OrganizationDefault)
     * @param tokentype Allowed Values :  \&quot;Access\&quot; (optional, default to Access)
     * @param tokenlifetime Allowed Values :  \&quot;default\&quot;, \&quot;short\&quot;, \&quot;long\&quot; (optional, default to default)
     * @return List&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<User> apiUserGet(String usertype, String userrole, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String guesthomeazureenvironment, String apptype, String publicclient, String signinaudience, String guesthomedin, String hasaltid, String altidsource, String altidtype, String passwordpolicyvalidityperiod, String passwordpolicynotificationdays, String tokenlifetimepolicy, String tokentype, String tokenlifetime) throws ApiException {
        ApiResponse<List<User>> resp = apiUserGetWithHttpInfo(usertype, userrole, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, guesthomeazureenvironment, apptype, publicclient, signinaudience, guesthomedin, hasaltid, altidsource, altidtype, passwordpolicyvalidityperiod, passwordpolicynotificationdays, tokenlifetimepolicy, tokentype, tokenlifetime);
        return resp.getData();
    }

    /**
     * Gets the Lab User(s) Based on Query Parameters with predefined defaults.   You can override the defaults.
     * 
     * @param usertype Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param userrole Allowed Values :  \&quot;none\&quot;, \&quot;clouddeviceadministrator\&quot; (optional, default to none)
     * @param mfa Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;truemamca\&quot;,\&quot;mamspo\&quot;, \&quot;blocked\&quot; (optional, default to none)
     * @param homedomain Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;none\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to adfsv4)
     * @param azureenvironment Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param guesthomeazureenvironment Allowed Values :  \&quot;none\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azureusgovernment\&quot; (optional, default to none)
     * @param apptype Allowed Values :  \&quot;cloud\&quot;, \&quot;onprem\&quot; (optional, default to cloud)
     * @param publicclient Allowed Values :  \&quot;yes\&quot;, \&quot;no\&quot; (optional, default to yes)
     * @param signinaudience Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @param guesthomedin Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot;, \&quot;hostazuread\&quot; (optional, default to none)
     * @param hasaltid Allowed Values :  \&quot;no\&quot;, \&quot;yes\&quot; (optional, default to no)
     * @param altidsource Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot; (optional, default to none)
     * @param altidtype Allowed Values :  \&quot;none\&quot;, \&quot;upn\&quot; (optional, default to none)
     * @param passwordpolicyvalidityperiod Allowed Values :  \&quot;60\&quot; (optional, default to 60)
     * @param passwordpolicynotificationdays Allowed Values :  \&quot;14\&quot;, \&quot;61\&quot; (optional, default to 14)
     * @param tokenlifetimepolicy Allowed Values :  \&quot;OrganizationDefault\&quot;, \&quot;CAE\&quot;, \&quot;CTL\&quot; (optional, default to OrganizationDefault)
     * @param tokentype Allowed Values :  \&quot;Access\&quot; (optional, default to Access)
     * @param tokenlifetime Allowed Values :  \&quot;default\&quot;, \&quot;short\&quot;, \&quot;long\&quot; (optional, default to default)
     * @return ApiResponse&lt;List&lt;User&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<User>> apiUserGetWithHttpInfo(String usertype, String userrole, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String guesthomeazureenvironment, String apptype, String publicclient, String signinaudience, String guesthomedin, String hasaltid, String altidsource, String altidtype, String passwordpolicyvalidityperiod, String passwordpolicynotificationdays, String tokenlifetimepolicy, String tokentype, String tokenlifetime) throws ApiException {
        com.squareup.okhttp.Call call = apiUserGetValidateBeforeCall(usertype, userrole, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, guesthomeazureenvironment, apptype, publicclient, signinaudience, guesthomedin, hasaltid, altidsource, altidtype, passwordpolicyvalidityperiod, passwordpolicynotificationdays, tokenlifetimepolicy, tokentype, tokenlifetime, null, null);
        Type localVarReturnType = TypeToken.getParameterized(List.class, User.class).getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the Lab User(s) Based on Query Parameters with predefined defaults.   You can override the defaults. (asynchronously)
     * 
     * @param usertype Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param userrole Allowed Values :  \&quot;none\&quot;, \&quot;clouddeviceadministrator\&quot; (optional, default to none)
     * @param mfa Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;truemamca\&quot;,\&quot;mamspo\&quot;, \&quot;blocked\&quot; (optional, default to none)
     * @param homedomain Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;none\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to adfsv4)
     * @param azureenvironment Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param guesthomeazureenvironment Allowed Values :  \&quot;none\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azureusgovernment\&quot; (optional, default to none)
     * @param apptype Allowed Values :  \&quot;cloud\&quot;, \&quot;onprem\&quot; (optional, default to cloud)
     * @param publicclient Allowed Values :  \&quot;yes\&quot;, \&quot;no\&quot; (optional, default to yes)
     * @param signinaudience Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @param guesthomedin Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot;, \&quot;hostazuread\&quot; (optional, default to none)
     * @param hasaltid Allowed Values :  \&quot;no\&quot;, \&quot;yes\&quot; (optional, default to no)
     * @param altidsource Allowed Values :  \&quot;none\&quot;, \&quot;onprem\&quot; (optional, default to none)
     * @param altidtype Allowed Values :  \&quot;none\&quot;, \&quot;upn\&quot; (optional, default to none)
     * @param passwordpolicyvalidityperiod Allowed Values :  \&quot;60\&quot; (optional, default to 60)
     * @param passwordpolicynotificationdays Allowed Values :  \&quot;14\&quot;, \&quot;61\&quot; (optional, default to 14)
     * @param tokenlifetimepolicy Allowed Values :  \&quot;OrganizationDefault\&quot;, \&quot;CAE\&quot;, \&quot;CTL\&quot; (optional, default to OrganizationDefault)
     * @param tokentype Allowed Values :  \&quot;Access\&quot; (optional, default to Access)
     * @param tokenlifetime Allowed Values :  \&quot;default\&quot;, \&quot;short\&quot;, \&quot;long\&quot; (optional, default to default)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiUserGetAsync(String usertype, String userrole, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String guesthomeazureenvironment, String apptype, String publicclient, String signinaudience, String guesthomedin, String hasaltid, String altidsource, String altidtype, String passwordpolicyvalidityperiod, String passwordpolicynotificationdays, String tokenlifetimepolicy, String tokentype, String tokenlifetime, final ApiCallback<List<User>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiUserGetValidateBeforeCall(usertype, userrole, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, guesthomeazureenvironment, apptype, publicclient, signinaudience, guesthomedin, hasaltid, altidsource, altidtype, passwordpolicyvalidityperiod, passwordpolicynotificationdays, tokenlifetimepolicy, tokentype, tokenlifetime, progressListener, progressRequestListener);
        Type localVarReturnType = TypeToken.getParameterized(List.class, User.class).getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for apiUserUpnGet
     * @param upn Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiUserUpnGetCall(String upn, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/User/{upn}"
            .replaceAll("\\{" + "upn" + "\\}", apiClient.escapeString(upn.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiUserUpnGetValidateBeforeCall(String upn, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'upn' is set
        if (upn == null) {
            throw new ApiException("Missing the required parameter 'upn' when calling apiUserUpnGet(Async)");
        }
        
        com.squareup.okhttp.Call call = apiUserUpnGetCall(upn, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Gets a single Lab User based on UPN
     * 
     * @param upn Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @return List&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<User> apiUserUpnGet(String upn) throws ApiException {
        ApiResponse<List<User>> resp = apiUserUpnGetWithHttpInfo(upn);
        return resp.getData();
    }

    /**
     * Gets a single Lab User based on UPN
     * 
     * @param upn Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @return ApiResponse&lt;List&lt;User&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<User>> apiUserUpnGetWithHttpInfo(String upn) throws ApiException {
        com.squareup.okhttp.Call call = apiUserUpnGetValidateBeforeCall(upn, null, null);
        Type localVarReturnType = TypeToken.getParameterized(List.class, User.class).getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets a single Lab User based on UPN (asynchronously)
     * 
     * @param upn Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiUserUpnGetAsync(String upn, final ApiCallback<List<User>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiUserUpnGetValidateBeforeCall(upn, progressListener, progressRequestListener);
        Type localVarReturnType = TypeToken.getParameterized(List.class, User.class).getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
