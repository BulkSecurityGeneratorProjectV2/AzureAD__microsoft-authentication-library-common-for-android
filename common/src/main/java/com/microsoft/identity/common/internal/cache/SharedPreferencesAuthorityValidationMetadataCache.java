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
package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.microsoft.identity.common.adal.internal.cache.IStorageHelper;
import com.microsoft.identity.common.adal.internal.cache.StorageHelper;

public class SharedPreferencesAuthorityValidationMetadataCache implements IDefaultAuthorityValidationMetadataCache {

    private static final String CACHE_VALUE_SEPARATOR = "-";
    private static final String AUTHORITY_VALIDATION_METADATA_CACHE_GUID = "33DD5583-1098-4617-AF07-2D327BC4C0E4";

    /**
     * The name of the SharedPreferences file on disk.
     * This file is only used to store MSAL CPP authority validation metadata
     */
    private static final String DEFAULT_CPP_AUTHORITY_VALIDATION_METADATA_SHARED_PREFERENCES =
            "com.microsoft.identity.client.cpp_authority_validation_metadata";

    private final ICacheKeyValueDelegate mCacheKeyValueDelegate;

    private final ISharedPreferencesFileManager mCppAuthorityValidationMetadataSharedPreferencesFileManager;

    public SharedPreferencesAuthorityValidationMetadataCache(final Context context) {
        mCacheKeyValueDelegate = new CacheKeyValueDelegate();

        final IStorageHelper storageHelper = new StorageHelper(context);
        mCppAuthorityValidationMetadataSharedPreferencesFileManager =
                SharedPreferencesFileManager.getSharedPreferences(
                        context,
                        DEFAULT_CPP_AUTHORITY_VALIDATION_METADATA_SHARED_PREFERENCES,
                        storageHelper
                );
    }

    @Override
    public String generateAuthorityValidationMetadataKey(final String environment) {
        return AUTHORITY_VALIDATION_METADATA_CACHE_GUID + CACHE_VALUE_SEPARATOR + environment;
    }

    @Override
    public void saveAuthorityValidationMetadata(final String environment, final String cacheValue) {
        final String cacheKey = generateAuthorityValidationMetadataKey(environment);
        mCppAuthorityValidationMetadataSharedPreferencesFileManager.putString(cacheKey, cacheValue);
    }

    @Override
    @Nullable
    public String getAuthorityValidationMetadata(final String environment) {
        final String cacheKey = generateAuthorityValidationMetadataKey(environment);
        return mCppAuthorityValidationMetadataSharedPreferencesFileManager.getString(cacheKey);
    }

    @Override
    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    public synchronized void clearCache() {
        mCppAuthorityValidationMetadataSharedPreferencesFileManager.clear();
    }
}
