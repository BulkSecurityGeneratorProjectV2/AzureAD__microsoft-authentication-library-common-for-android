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

package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.util.ported.InMemoryStorage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ClockSkewManagerTest {

    @Test
    public void testOnTimestampReceived() {
        final IClockSkewManager clockSkewManager = new ClockSkewManager(new InMemoryStorage<Long>()) {
            @Override
            public Date getCurrentClientTime() {
                return new Date(12345);
            }
        };

        final Date serverTime = new Date(67890);
        clockSkewManager.onTimestampReceived(serverTime.getTime());
        assertEquals(-55545, clockSkewManager.getSkewMillis());
    }

    @Test
    public void testOnTimestampReceived2() {
        final IClockSkewManager clockSkewManager = new ClockSkewManager(new InMemoryStorage<Long>()) {
            @Override
            public Date getCurrentClientTime() {
                return new Date(67890);
            }
        };

        final Date serverTime = new Date(12345);
        clockSkewManager.onTimestampReceived(serverTime.getTime());
        assertEquals(55545, clockSkewManager.getSkewMillis());
    }

    @Test
    public void testGetReferenceTime() {
        final IClockSkewManager clockSkewManager = new ClockSkewManager(new InMemoryStorage<Long>()) {
            @Override
            public Date getCurrentClientTime() {
                return new Date(67890);
            }

            @Override
            public long getSkewMillis() {
                return 42L;
            }
        };

        assertEquals(67848L, clockSkewManager.getAdjustedReferenceTime().getTime());
    }

    @Test
    public void testToClientTime() {
        final IClockSkewManager clockSkewManager = new ClockSkewManager(new InMemoryStorage<Long>()) {
            @Override
            public long getSkewMillis() {
                return 42L;
            }
        };

        assertEquals(67932L, clockSkewManager.toClientTime(67890).getTime());
    }

    @Test
    public void testToReferenceTime() {
        final IClockSkewManager clockSkewManager = new ClockSkewManager(new InMemoryStorage<Long>()) {
            @Override
            public long getSkewMillis() {
                return 42L;
            }
        };

        assertEquals(67848L, clockSkewManager.toReferenceTime(67890).getTime());
    }
}

