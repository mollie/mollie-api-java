package com.mollie.mollie.hooks;

//
// This file is written once by speakeasy code generation and
// thereafter will not be overwritten by speakeasy updates. As a
// consequence any customization of this class will be preserved.
//

public final class SDKHooks {

    private SDKHooks() {
        // prevent instantiation
    }

    public static void initialize(com.mollie.mollie.utils.Hooks hooks) {
        hooks.registerBeforeRequest(new MollieHooks());
    }

    public static void initialize(com.mollie.mollie.utils.AsyncHooks asyncHooks) {
        // Use the adapter to convert sync hook to async
        asyncHooks.registerBeforeRequest(com.mollie.mollie.utils.HookAdapters.toAsync(new MollieHooks()));
    }

}
