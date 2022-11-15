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
package com.microsoft.identity.common.internal.ipc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.HelloCache;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.internal.controllers.BrokerMsalController;
import com.microsoft.identity.common.internal.util.StringUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.microsoft.identity.common.adal.internal.AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.N})
public class HelloCacheTests {

    public static String protocolA = "MOCK_PROTOCOL_A";
    public static String protocolB = "MOCK_PROTOCOL_B";
    public static String brokerAppName = "MOCK_BROKER_APP_NAME";
    public static String appVersion = "1.0";
    public static String newAppVersion = "2.0";

    @After
    public void cleanUp() {
        getHelloCache(protocolA).clearCache();
        getHelloCache(protocolB).clearCache();
    }

    @Test
    public void testReadWrite() {
        final HelloCache cacheWrite = getHelloCache(protocolA);
        final HelloCache cacheRead = getHelloCache(protocolA);

        final String minimumVer = "1.0";
        final String maximumVer = "2.5";
        final String negotiatedVer = "2.0";

        cacheWrite.saveNegotiatedProtocolVersion(minimumVer, maximumVer, negotiatedVer);
        Assert.assertEquals(cacheRead.tryGetNegotiatedProtocolVersion(minimumVer, maximumVer), negotiatedVer);
    }

    @Test
    public void testReadAfterUpdateMinVersion() {
        final HelloCache cacheWrite = getHelloCache(protocolA);
        final HelloCache cacheRead = getHelloCache(protocolA);

        final String minimumVer = "1.0";
        final String maximumVer = "2.5";
        final String negotiatedVer = "2.0";

        final String newMinimumVer = "1.2";

        cacheWrite.saveNegotiatedProtocolVersion(minimumVer, maximumVer, negotiatedVer);
        Assert.assertNull(cacheRead.tryGetNegotiatedProtocolVersion(newMinimumVer, maximumVer));
    }

    @Test
    public void testReadAfterUpdateMaxVersion() {
        final HelloCache cacheWrite = getHelloCache(protocolA);
        final HelloCache cacheRead = getHelloCache(protocolA);

        final String minimumVer = "1.0";
        final String maximumVer = "2.5";
        final String negotiatedVer = "2.0";

        final String newMaximumVer = "2.7";

        cacheWrite.saveNegotiatedProtocolVersion(minimumVer, maximumVer, negotiatedVer);
        Assert.assertNull(cacheRead.tryGetNegotiatedProtocolVersion(minimumVer, newMaximumVer));
    }

    @Test
    public void testReadForProtocolAAfterWritingForProtocolB() {
        final HelloCache cacheProtocolA = getHelloCache(protocolA);
        final HelloCache cacheProtocolB = getHelloCache(protocolB);

        final String minimumVerProtocolA = "1.0";
        final String maximumVerProtocolA = "2.5";
        final String negotiatedVerProtocolA = "2.0";

        final String minimumVerProtocolB = "100.0";
        final String maximumVerProtocolB = "200.5";
        final String negotiatedVerProtocolB = "200.0";

        cacheProtocolA.saveNegotiatedProtocolVersion(minimumVerProtocolA, maximumVerProtocolA, negotiatedVerProtocolA);
        cacheProtocolB.saveNegotiatedProtocolVersion(minimumVerProtocolB, maximumVerProtocolB, negotiatedVerProtocolB);

        Assert.assertEquals(cacheProtocolA.tryGetNegotiatedProtocolVersion(minimumVerProtocolA, maximumVerProtocolA), negotiatedVerProtocolA);
        Assert.assertNull(cacheProtocolA.tryGetNegotiatedProtocolVersion(minimumVerProtocolB, maximumVerProtocolB));

        Assert.assertEquals(cacheProtocolB.tryGetNegotiatedProtocolVersion(minimumVerProtocolB, maximumVerProtocolB), negotiatedVerProtocolB);
        Assert.assertNull(cacheProtocolB.tryGetNegotiatedProtocolVersion(minimumVerProtocolA, maximumVerProtocolA));
    }

    @Test
    public void testReadAfterUpdateTargetApp() {
        final HelloCache cacheBeforeUpdate = getHelloCache(protocolA);
        final String minimumVer = "1.0";
        final String maximumVer = "2.5";
        final String negotiatedVer = "2.0";

        cacheBeforeUpdate.saveNegotiatedProtocolVersion(minimumVer, maximumVer, negotiatedVer);

        final HelloCache cacheAfterUpdate = getHelloCache(protocolA, newAppVersion);
        Assert.assertNull(cacheAfterUpdate.tryGetNegotiatedProtocolVersion(minimumVer, maximumVer));
    }

    @Test
    public void testReadAfterTargetAppUninstalled() {
        final HelloCache cacheBeforeUninstall = getHelloCache(protocolA);
        final String minimumVer = "1.0";
        final String maximumVer = "2.5";
        final String negotiatedVer = "2.0";

        cacheBeforeUninstall.saveNegotiatedProtocolVersion(minimumVer, maximumVer, negotiatedVer);

        final HelloCache cacheAfterUninstall = getHelloCache(protocolA, null);
        Assert.assertNull(cacheAfterUninstall.tryGetNegotiatedProtocolVersion(minimumVer, maximumVer));
    }

    @Test
    public void testHelloShouldOnlyTriggerOnce() {

        final String minimumVer = "1.0";
        final String negotiatedVer = "2.5";

        class MockStrategy implements IIpcStrategy {
            int triggered = 0;

            @Nullable @Override public Bundle communicateToBroker(@NonNull BrokerOperationBundle bundle) throws BrokerCommunicationException {
                triggered += 1;
                if (triggered == 2) {
                    Assert.fail("Should never be triggered");
                }

                final Bundle resultBundle = new Bundle();
                resultBundle.putString(NEGOTIATED_BP_VERSION_KEY, negotiatedVer);
                return resultBundle;
            }

            @Override public Type getType() {
                return Type.CONTENT_PROVIDER;
            }
        }

        class MockController extends BrokerMsalController {
            public MockController(Context applicationContext) {
                super(applicationContext);
            }

            @Override
            public HelloCache getHelloCache() {
                return HelloCacheTests.this.getHelloCache(protocolA);
            }

            @Override public String getActiveBrokerPackageName() {
                return brokerAppName;
            }
        }

        final MockController controller = new MockController(ApplicationProvider.getApplicationContext());
        final MockStrategy strategy = new MockStrategy();
        final CommandParameters parameters = CommandParameters.builder()
                .platformComponents(AndroidPlatformComponentsFactory.createFromContext(ApplicationProvider.getApplicationContext()))
                .requiredBrokerProtocolVersion(minimumVer).build();

        try {
            final String negotiatedProtocolVersion = controller.hello(strategy, parameters.getRequiredBrokerProtocolVersion());
            final String negotiatedProtocolVersion2 = controller.hello(strategy, parameters.getRequiredBrokerProtocolVersion());
            Assert.assertEquals(negotiatedProtocolVersion, negotiatedProtocolVersion2);
        } catch (BaseException e) {
            Assert.fail();
        }
    }

    private HelloCache getHelloCache(@NonNull final String protocol) {
        return getHelloCache(protocol, appVersion);
    }

    private HelloCache getHelloCache(@NonNull final String protocol,
                                     @Nullable final String appVersionCode) {

        class HelloCacheMock extends HelloCache {
            public HelloCacheMock(@NonNull Context context, @NonNull String protocolName, @NonNull String targetAppPackageName) {
                super(context, protocolName, targetAppPackageName, AndroidPlatformComponentsFactory.createFromContext(context));
            }

            @NonNull @Override public String getVersionCode() throws PackageManager.NameNotFoundException {
                if (StringUtil.isEmpty(appVersionCode)) {
                    throw new PackageManager.NameNotFoundException("error!");
                }
                return appVersionCode;
            }
        }

        return new HelloCacheMock(ApplicationProvider.getApplicationContext(), protocol, brokerAppName);
    }
}
