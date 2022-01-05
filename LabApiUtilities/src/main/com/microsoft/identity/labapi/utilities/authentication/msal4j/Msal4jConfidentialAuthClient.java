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
package com.microsoft.identity.labapi.utilities.authentication.msal4j;

import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IClientCredential;
import com.microsoft.identity.labapi.utilities.authentication.IAuthenticationResult;
import com.microsoft.identity.labapi.utilities.authentication.IConfidentialAuthClient;
import com.microsoft.identity.labapi.utilities.authentication.ITokenParameters;
import com.microsoft.identity.labapi.utilities.authentication.common.CertificateCredential;
import com.microsoft.identity.labapi.utilities.authentication.common.ClientAssertion;

import lombok.NonNull;
import lombok.SneakyThrows;

/**
 * An {@link IConfidentialAuthClient} that uses MSAL4J for token acquisition.
 */
public class Msal4jConfidentialAuthClient implements IConfidentialAuthClient {

    @Override
    public IAuthenticationResult acquireToken(@NonNull final String clientSecret,
                                              @NonNull final ITokenParameters tokenParameters) {
        final IClientCredential credential = ClientCredentialFactory.createFromSecret(clientSecret);
        return acquireToken(credential, tokenParameters);
    }

    @Override
    public IAuthenticationResult acquireToken(@NonNull final ClientAssertion clientAssertion,
                                              @NonNull final ITokenParameters tokenParameters) {
        final IClientCredential credential = ClientCredentialFactory.createFromClientAssertion(clientAssertion.getClientAssertion());
        return acquireToken(credential, tokenParameters);
    }

    @Override
    public IAuthenticationResult acquireToken(@NonNull final CertificateCredential certificateCredential,
                                              @NonNull final ITokenParameters tokenParameters) {
        final IClientCredential credential = ClientCredentialFactory.createFromCertificate(
                certificateCredential.getPrivateKey(), certificateCredential.getPublicCertificate()
        );
        return acquireToken(credential, tokenParameters);
    }

    @SneakyThrows
    private IAuthenticationResult acquireToken(@NonNull final IClientCredential clientCredential,
                                               @NonNull final ITokenParameters tokenParameters) {
        final ConfidentialClientApplication app =
                ConfidentialClientApplication
                        .builder(tokenParameters.getClientId(), clientCredential)
                        .authority(tokenParameters.getAuthority())
                        .build();

        final ClientCredentialParameters clientCredentialParameters = ClientCredentialParameters
                .builder(tokenParameters.getScopes())
                .build();

        final com.microsoft.aad.msal4j.IAuthenticationResult result =
                app.acquireToken(clientCredentialParameters).get();

        return new Msal4jAuthenticationResult(result);
    }
}
