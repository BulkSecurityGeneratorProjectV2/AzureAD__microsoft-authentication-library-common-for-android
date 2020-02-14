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
package com.microsoft.identity.common.internal.commands;

import androidx.annotation.NonNull;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.ErrorStrings;
import com.microsoft.identity.common.exception.UiRequiredException;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.request.generated.CommandContext;
import com.microsoft.identity.common.internal.request.generated.SilentTokenCommandParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;

import java.util.List;

public class SilentTokenCommand extends BaseCommand<AcquireTokenResult,
        CommandContext,
        SilentTokenCommandParameters,
        CommandCallback
        > {

    private static final String TAG = SilentTokenCommand.class.getSimpleName();

    public SilentTokenCommand(@NonNull final CommandContext commandContext,
                              @NonNull final SilentTokenCommandParameters commandParameters,
                              @NonNull final BaseController controller,
                              @NonNull final CommandCallback callback) {
        super(commandContext, commandParameters, controller, callback);
    }

    public SilentTokenCommand(@NonNull final CommandContext commandContext,
                              @NonNull final SilentTokenCommandParameters commandParameters,
                              @NonNull final List<BaseController> controllers,
                              @NonNull final CommandCallback callback) {
        super(commandContext, commandParameters, controllers, callback);
    }

    @Override
    public AcquireTokenResult execute() throws Exception {
        AcquireTokenResult result = null;
        final String methodName = ":execute";

        for (int ii = 0; ii < this.getControllers().size(); ii++) {
            final BaseController controller = this.getControllers().get(ii);

            try {
                com.microsoft.identity.common.internal.logging.Logger.verbose(
                        TAG + methodName,
                        "Executing with controller: "
                                + controller.getClass().getSimpleName()
                );

                result = controller.acquireTokenSilent(
                        this.getContext(),
                        this.getParameters()
                );

                if (result.getSucceeded()) {
                    com.microsoft.identity.common.internal.logging.Logger.verbose(
                            TAG + methodName,
                            "Executing with controller: "
                                    + controller.getClass().getSimpleName()
                                    + ": Succeeded"
                    );

                    return result;
                }
            } catch (UiRequiredException | ClientException e) {
                if (e.getErrorCode().equals(AuthenticationConstants.OAuth2ErrorCode.INVALID_GRANT) // was invalid_grant
                        && this.getControllers().size() > ii + 1) { // isn't the last controller we can try
                    continue;
                } else if ((e.getErrorCode().equals(ErrorStrings.NO_TOKENS_FOUND)
                        || e.getErrorCode().equals(ErrorStrings.NO_ACCOUNT_FOUND))
                        && this.getControllers().size() > ii + 1) {
                    //if no token or account for this silent call, we should continue to the next silent call.
                    continue;
                } else {
                    throw e;
                }
            }
        }

        return result;
    }

    @Override
    public boolean isEligibleForCaching() {
        return true;
    }

    @Override
    public int getCommandNameHashCode() {
        return TAG.hashCode();
    }

}
