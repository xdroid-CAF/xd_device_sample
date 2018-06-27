package com.google.android.tv.setup.customizationsample;

import android.content.Intent;

/**
 * A PRE_CORE_SETUP Activity.
 */
public class PreCore2Activity extends HookActivity {

    private static final String EXTRA_OEM_NETWORK_SETUP = "OEM_NETWORK_SETUP";
    private static final String EXTRA_OEM_NETWORK_SETUP_SKIPPED = "OEM_NETWORK_SETUP_SKIPPED";

    @Override
    protected void onAboutToFinish() {
        Intent intent = new Intent();

        // Set this to true to inform TV Setup that the partner has handled the network setup.
        // A present and true value means that TV Setup will not show the default Network step
        // (because the partner has already handled it and it would be weird for the user to see
        // the default Network step after already having gone through the partner's.
        if (getIntent().getBooleanExtra(EXTRA_OEM_NETWORK_SETUP, false)) {
            // We read the extra from the incoming Intent only for testing purposes. Normally, this
            // partner Activity would have its own reasons for returning this extra back to Setup.
            intent.putExtra(EXTRA_OEM_NETWORK_SETUP, true);
        }

        // Set this to true to inform TV Setup that the partner has handled the network setup and
        // that the user chose to skip setting up a network connection.
        // A present and true value means that TV Setup will not show steps that require a network
        // connection.

        if (getIntent().getBooleanExtra(EXTRA_OEM_NETWORK_SETUP_SKIPPED, false)) {
            // We read the extra from the incoming Intent only for testing purposes. Normally, this
            // partner Activity would have its own reasons for returning this extra back to Setup.
            intent.putExtra(EXTRA_OEM_NETWORK_SETUP_SKIPPED, true);
        }

        setResult(RESULT_OK, intent);
    }
}
