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

//  Copyright (c) Microsoft Corporation.
//  All rights reserved.
//
//  This code is licensed under the MIT License.
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files(the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions :
//
//  The above copyright notice and this permission notice shall be included in
//  all copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//  THE SOFTWARE.
package com.microsoft.identity.internal.testutils.mocks;

import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.internal.testutils.TestConstants;

public class MockTokenResponse {

    private static final long ACCESS_TOKEN_AGE = 3599;
    private static final String TOKEN_TYPE = "Bearer";

    public static MicrosoftStsTokenResponse getMockSuccessTokenResponse() {
        String mockAccessToken = "aaaa.BBBB.123";
        String mockRefreshToken = "abcDeFGhijkl";
        String mockIdToken = MockTokenCreator.createMockIdTokenWithTenantId(TestConstants.Authorities.AAD_MOCK_AUTHORITY_TENANT);
        String mockClientInfo = MockTokenCreator.createMockRawClientInfo();

        MicrosoftStsTokenResponse tokenResponse = new MicrosoftStsTokenResponse();

        tokenResponse.setExpiresIn(ACCESS_TOKEN_AGE);
        tokenResponse.setExtExpiresIn(ACCESS_TOKEN_AGE);
        tokenResponse.setAccessToken(mockAccessToken);
        tokenResponse.setTokenType(TOKEN_TYPE);
        tokenResponse.setRefreshToken(mockRefreshToken);
        tokenResponse.setScope("User.Read");
        tokenResponse.setIdToken(mockIdToken);
        tokenResponse.setClientInfo(mockClientInfo);
        tokenResponse.setRefreshTokenAge("");
        tokenResponse.setCliTelemErrorCode("0");
        tokenResponse.setCliTelemSubErrorCode("0");
        tokenResponse.setResponseReceivedTime(Long.valueOf(0));

        return tokenResponse;
    }

    public static MicrosoftStsTokenResponse getMockTokenResponseWithExpiredAccessToken() {
        MicrosoftStsTokenResponse tokenResponse = getMockSuccessTokenResponse();
        tokenResponse.setExpiresIn(Long.valueOf(0));
        tokenResponse.setExtExpiresIn(Long.valueOf(0));
        return tokenResponse;
    }

}
