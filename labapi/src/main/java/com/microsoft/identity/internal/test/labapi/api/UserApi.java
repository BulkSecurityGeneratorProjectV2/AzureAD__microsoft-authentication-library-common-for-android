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

import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.internal.test.labapi.ApiCallback;
import com.microsoft.identity.internal.test.labapi.ApiClient;
import com.microsoft.identity.internal.test.labapi.ApiException;
import com.microsoft.identity.internal.test.labapi.ApiResponse;
import com.microsoft.identity.internal.test.labapi.Configuration;
import com.microsoft.identity.internal.test.labapi.Pair;
import com.microsoft.identity.internal.test.labapi.ProgressRequestBody;
import com.microsoft.identity.internal.test.labapi.ProgressResponseBody;
import com.microsoft.identity.internal.test.labapi.model.UserInfo;

import java.io.IOException;
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
     * Build call for get
     *
     * @param usertype                Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param mfa                     Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy        Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;mamspo\&quot; (optional, default to none)
     * @param homedomain              Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn                 Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider             Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider      Allowed Values :  \&quot;na\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to ADFSV4)
     * @param azureenvironment        Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param signinaudience          Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCall(String usertype, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String signinaudience, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/User";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (usertype != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("usertype", usertype));
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
        if (signinaudience != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("signinaudience", signinaudience));

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

        if (progressListener != null) {
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

        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getValidateBeforeCall(String usertype, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String signinaudience, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {


        com.squareup.okhttp.Call call = getCall(usertype, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, signinaudience, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets the Lab User(s) Based on Query Parameters with predefined defaults.   You can override the defaults.
     *
     * @param usertype           Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param mfa                Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy   Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;mamspo\&quot; (optional, default to none)
     * @param homedomain         Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn            Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider        Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;na\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to ADFSV4)
     * @param azureenvironment   Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param signinaudience     Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @return List&lt;UserInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<UserInfo> get(String usertype, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String signinaudience) throws ApiException {
        ApiResponse<List<UserInfo>> resp = getWithHttpInfo(usertype, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, signinaudience);
        return resp.getData();
    }

    /**
     * Gets the Lab User(s) Based on Query Parameters with predefined defaults.   You can override the defaults.
     *
     * @param usertype           Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param mfa                Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy   Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;mamspo\&quot; (optional, default to none)
     * @param homedomain         Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn            Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider        Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;na\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to ADFSV4)
     * @param azureenvironment   Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param signinaudience     Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @return ApiResponse&lt;List&lt;UserInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<UserInfo>> getWithHttpInfo(String usertype, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String signinaudience) throws ApiException {
        com.squareup.okhttp.Call call = getValidateBeforeCall(usertype, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, signinaudience, null, null);
        Type localVarReturnType = new TypeToken<List<UserInfo>>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the Lab User(s) Based on Query Parameters with predefined defaults.   You can override the defaults. (asynchronously)
     *
     * @param usertype           Allowed Values :  \&quot;cloud\&quot;, \&quot;federated\&quot;, \&quot;onprem\&quot;, \&quot;guest\&quot;, \&quot;msa\&quot;, \&quot;b2c\&quot; (optional, default to cloud)
     * @param mfa                Allowed Values :  \&quot;none\&quot;, \&quot;mfaonall\&quot;, \&quot;automfaonall\&quot; (optional, default to none)
     * @param protectionpolicy   Allowed Values :  \&quot;none\&quot;, \&quot;ca\&quot;, \&quot;cadj\&quot;, \&quot;mam\&quot;, \&quot;mdm\&quot;, \&quot;mdmca\&quot;, \&quot;mamca\&quot;, \&quot;mamspo\&quot; (optional, default to none)
     * @param homedomain         Allowed Values :  \&quot;none\&quot;, \&quot;msidlab2.com\&quot;, \&quot;msidlab3.com\&quot;, \&quot;msidlab4.com\&quot; (optional, default to none)
     * @param homeupn            Allowed Values :  \&quot;none\&quot;, \&quot;gidlab@msidlab2.com\&quot;, \&quot;gidlab@msidlab3.com\&quot;, \&quot;gidlab@msidlab4.com\&quot; (optional, default to none)
     * @param b2cprovider        Allowed Values :  \&quot;none\&quot;, \&quot;amazon\&quot;, \&quot;facebook\&quot;, \&quot;google\&quot;, \&quot;local\&quot;, \&quot;microsoft\&quot;, \&quot;twitter\&quot; (optional, default to none)
     * @param federationprovider Allowed Values :  \&quot;na\&quot;, \&quot;adfsv2\&quot;, \&quot;adfsv3\&quot;, \&quot;adfsv4\&quot;, \&quot;adfsv2019\&quot;, \&quot;b2c\&quot;, \&quot;ping\&quot;, \&quot;shibboleth\&quot; (optional, default to ADFSV4)
     * @param azureenvironment   Allowed Values :  \&quot;azureb2ccloud\&quot;, \&quot;azurechinacloud\&quot;, \&quot;azurecloud\&quot;, \&quot;azuregermanycloud\&quot;, \&quot;azureppe\&quot;, \&quot;azureusgovernment\&quot; (optional, default to azurecloud)
     * @param signinaudience     Allowed Values :  \&quot;azureadmyorg\&quot;, \&quot;azureadmultipleorgs\&quot;, \&quot;azureadandpersonalmicrosoftaccount\&quot; (optional, default to azureadmultipleorgs)
     * @param callback           The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAsync(String usertype, String mfa, String protectionpolicy, String homedomain, String homeupn, String b2cprovider, String federationprovider, String azureenvironment, String signinaudience, final ApiCallback<List<UserInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getValidateBeforeCall(usertype, mfa, protectionpolicy, homedomain, homeupn, b2cprovider, federationprovider, azureenvironment, signinaudience, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<UserInfo>>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for getUserByUPN
     *
     * @param upn                     Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUserByUPNCall(String upn, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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

        if (progressListener != null) {
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

        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserByUPNValidateBeforeCall(String upn, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'upn' is set
        if (upn == null) {
            throw new ApiException("Missing the required parameter 'upn' when calling getUserByUPN(Async)");
        }


        com.squareup.okhttp.Call call = getUserByUPNCall(upn, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets a single Lab User based on UPN
     *
     * @param upn Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @return List&lt;UserInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<UserInfo> getUserByUPN(String upn) throws ApiException {
        ApiResponse<List<UserInfo>> resp = getUserByUPNWithHttpInfo(upn);
        return resp.getData();
    }

    /**
     * Gets a single Lab User based on UPN
     *
     * @param upn Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @return ApiResponse&lt;List&lt;UserInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<UserInfo>> getUserByUPNWithHttpInfo(String upn) throws ApiException {
        com.squareup.okhttp.Call call = getUserByUPNValidateBeforeCall(upn, null, null);
        Type localVarReturnType = new TypeToken<List<UserInfo>>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets a single Lab User based on UPN (asynchronously)
     *
     * @param upn      Enter the UPN of the Lab User. You cannot Query Locked Users at this endpoint. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserByUPNAsync(String upn, final ApiCallback<List<UserInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getUserByUPNValidateBeforeCall(upn, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<UserInfo>>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
