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
package com.microsoft.identity.common.java.opentelemetry;

/**
 * Names of Open Telemetry Span Attributes we want to capture for broker's Spans.
 */
public enum AttributeName {
    /**
     * The length of the response body returned from network request.
     */
    response_body_length,
    /**
     * Indicates if the JWT returned by eSTS is a valid JWT.
     */
    jwt_valid,
    /**
     * Indicates the algorithm for the JWE returned by eSTS.
     */
    jwt_alg,

    /**
     * Indicates name of the parent span.
     */
    parent_span_name,

    /**
     * Indicates the controller for crypto operation (in FIPS flows).
     */
    crypto_controller,

    /**
     * Indicates the crypto operation.
     */
    crypto_operation,

    /**
     * Indicates the stack trace from an crypto operation exception.
     */
    crypto_exception_stack_trace,

    /**
     * Indicates the request id value for cached credential service (if used) on server side
     */
    ccs_request_id,
}
