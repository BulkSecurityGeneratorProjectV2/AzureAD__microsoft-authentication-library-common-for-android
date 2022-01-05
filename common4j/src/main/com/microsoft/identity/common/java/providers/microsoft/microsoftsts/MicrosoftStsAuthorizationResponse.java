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
package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;

import java.util.Map;

/**
 * Sub class of {@link MicrosoftAuthorizationResponse} which encapsulates additional parameters
 * specific to Microsoft STS in addition to the that of MicrosoftAuthorizationResponse.
 */
public class MicrosoftStsAuthorizationResponse extends MicrosoftAuthorizationResponse {

    /**
     * Constructor of {@link MicrosoftStsAuthorizationResponse}.
     *
     * @param code  The authorization code generated by the authorization server.
     * @param state "state" parameter from the client authorization request.
     */
    public MicrosoftStsAuthorizationResponse(final String code, final String state, final Map<String, String> otherParameters) {
        super(code, state);

        mCloudGraphHostName = otherParameters.get(MicrosoftAuthorizationResponse.CLOUD_GRAPH_HOST_NAME);
        mCloudInstanceHostName = otherParameters.get(MicrosoftAuthorizationResponse.CLOUD_INSTANCE_HOST_NAME);
        mCloudInstanceName = otherParameters.get(MicrosoftAuthorizationResponse.CLOUD_INSTANCE_NAME);
        mSessionState = otherParameters.get(MicrosoftAuthorizationResponse.SESSION_STATE);
        mDeviceCode = otherParameters.get(MicrosoftAuthorizationResponse.DEVICE_CODE);
        mUserCode = otherParameters.get(MicrosoftAuthorizationResponse.USER_CODE);
        mVerificationUri = otherParameters.get(MicrosoftAuthorizationResponse.VERIFICATION_URI);
        mExpiresIn = otherParameters.get(MicrosoftAuthorizationResponse.EXPIRES_IN);
        mInterval = otherParameters.get(MicrosoftAuthorizationResponse.INTERVAL);
        mMessage = otherParameters.get(MicrosoftAuthorizationResponse.MESSAGE);

    }

}
