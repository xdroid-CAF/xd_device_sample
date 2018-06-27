package com.google.android.tv.setup.customizationsample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * A OEM_OTA_CHECK_SETUP Activity, which simulates checking for a system upgrade.
 */
public class UpgradeCheckActivity extends BaseActivity {

    int mSecondsRemaining;
    Runnable mRunnable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here we pretend that we are checking if an upgrade is available.
        // We do not make visible any UI elements; instead we allow Android TV Setup's "Please wait"
        // step to show under us while we figure out if an upgrade is available. That way there are
        // fewer transitions which is especially useful in case we have nothing important to do.
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSecondsRemaining--;
                if (mSecondsRemaining >= 0) {
                    tv3.setText(mSecondsRemaining + " seconds remaining");
                    new Handler().postDelayed(mRunnable, 1000);
                } else {
                    // This skip_stage_2 stuff is just for testing - so that we can exercise the
                    // case where no follow-up Activity is needed.
                    if (getIntent().getBooleanExtra("skip_follow_up", false)) {
                        log("hook post-network: return no follow-up Activity Intent");
                        setResult(RESULT_OK);
                        finish();
                    } else {
                        log("hook post-network: return follow-up Activity Intent");
                        Intent intent = new Intent(getApplicationContext(), UpgradePerformActivity.class);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        };
        mSecondsRemaining = 3;
        mRunnable.run();
    }
}


