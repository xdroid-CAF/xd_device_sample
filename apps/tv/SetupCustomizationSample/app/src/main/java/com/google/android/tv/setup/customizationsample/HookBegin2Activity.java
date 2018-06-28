package com.google.android.tv.setup.customizationsample;

import android.content.Intent;

/**
 * A HOOK_BEGIN Activity.
 */
public class HookBegin2Activity extends HookActivity {

    private static final String EXTRA_PARTNER_HANDLED_NETWORK = "partner_handled_network";
    private static final String EXTRA_PARTNER_HANDLED_NETWORK_USER_SKIPPED = "partner_handled_network_user_skipped";

    @Override
    protected void onAboutToFinish() {
        Intent intent = new Intent();

        // Set this to true to inform TV Setup that the partner has handled the network setup.
        // A present and true value means that TV Setup will not show the default Network step
        // (because the partner has already handled it and it would be weird for the user to see
        // the default Network step after already having gone through the partner's.
        if (getIntent().getBooleanExtra(EXTRA_PARTNER_HANDLED_NETWORK, false)) {
            // We read the extra from the incoming Intent only for testing purposes. Normally, this
            // partner Activity would have its own reasons for returning this extra back to Setup.
            intent.putExtra(EXTRA_PARTNER_HANDLED_NETWORK, true);
        }

        // Set this to true to inform TV Setup that the partner has handled the network setup and
        // that the user chose to skip setting up a network connection.
        // A present and true value means that TV Setup will not show steps that require a network
        // connection.
        if (getIntent().getBooleanExtra(EXTRA_PARTNER_HANDLED_NETWORK_USER_SKIPPED, false)) {
            // We read the extra from the incoming Intent only for testing purposes. Normally, this
            // partner Activity would have its own reasons for returning this extra back to Setup.
            intent.putExtra(EXTRA_PARTNER_HANDLED_NETWORK_USER_SKIPPED, true);
        }

        setResult(RESULT_OK, intent);
    }
}
