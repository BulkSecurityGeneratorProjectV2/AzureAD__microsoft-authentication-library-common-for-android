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

package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.util.StringUtil;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.extras.Base64;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

public class JweResponse {

    @Builder
    @Getter
    @Accessors(prefix = "m")
    public static class JweHeader {
        private final String mAlgorithm;

        private final String mType;

        private final String mX509CertificateThumbprint;

        private final String mX509Certificate;

        private final String mKeyID;

        private final String mKeyUse;

        private final String mEncryptionAlgorithm;

        private final String mContext;
    }

    JweHeader mJweHeader;

    String mEncryptedKey;

    String mIv;

    String mPayload;

    String mAuthenticationTag;

    public JweHeader getJweHeader() {
        return mJweHeader;
    }

    public String getEncryptedKey() {
        return mEncryptedKey;
    }

    public String getIV() {
        return mIv;
    }

    public String getPayload() {
        return mPayload;
    }

    public String getAuthenticationTag() {
        return mAuthenticationTag;
    }

    public static JweResponse parseJwe(String jwe) throws JSONException {
        JweResponse response = new JweResponse();

        String[] split = jwe.split("\\.");
        if (split.length < 4) {
            throw new IllegalArgumentException("Invalid JWE");
        }

        String header = split[0];
        response.mEncryptedKey = split[1];
        response.mIv = split[2];
        response.mPayload = split[3];

        if (split.length > 4) {
            response.mAuthenticationTag = split[4];
        }

        byte[] headerDecodedBytes = Base64.decode(header, Base64.URL_SAFE);
        String decodedHeader = StringUtil.fromByteArray(headerDecodedBytes);

        JSONObject jsonObject = new JSONObject(decodedHeader);
        response.mJweHeader = JweHeader.builder()
                .algorithm(jsonObject.optString("alg"))
                .type(jsonObject.optString("typ"))
                .x509CertificateThumbprint(jsonObject.optString("x5t"))
                .x509Certificate(jsonObject.optString("x5c"))
                .keyID(jsonObject.optString("kid"))
                .keyUse(jsonObject.optString("use"))
                .encryptionAlgorithm(jsonObject.optString("enc"))
                .context(jsonObject.optString("ctx"))
                .build();

        return response;
    }
}
