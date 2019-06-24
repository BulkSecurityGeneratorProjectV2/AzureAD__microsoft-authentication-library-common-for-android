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
package com.microsoft.identity.common.internal.telemetry.events;

import static com.microsoft.identity.common.internal.telemetry.TelemetryEventStrings.*;

public class CacheEndEvent extends BaseEvent {
    private static final String TAG = CacheEndEvent.class.getSimpleName();

    public CacheEndEvent() {
        super();
        names(TELEMETRY_EVENT_CACHE_EVENT_END);
    }

    public CacheEndEvent putResultStatus(final String resultStatus) {
        put(TELEMETRY_KEY_RESULT_STATUS, resultStatus);
        return this;
    }

    public CacheEndEvent putRtStatus(final String rtStatus) {
        put(TELEMETRY_KEY_RT_STATUS, rtStatus);
        return this;
    }

    public CacheEndEvent putMrrtStatus(final String mrrtStatus) {
        put(TELEMETRY_KEY_MRRT_STATUS, mrrtStatus);
        return this;
    }

    public CacheEndEvent putFrtStatus(final String frtStatus) {
        put(TELEMETRY_KEY_FRT_STATUS, frtStatus);
        return this;
    }

    public CacheEndEvent putSpeInfo(final String speInfo) {
        put(TELEMETRY_KEY_SPE_INFO, speInfo);
        return this;
    }
}
