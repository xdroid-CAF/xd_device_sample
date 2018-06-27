package com.google.android.tv.setup.customizationsample;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;

/**
 * A OEM_OTA_CHECK_SETUP follow-up Activity, which simulates performing a system upgrade.
 */
public class UpgradePerformActivity extends BaseActivity {

    int mSecondsRemaining;
    Runnable mRunnable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here we pretend to perform a system upgrade.
        iv0.setVisibility(View.VISIBLE);
        iv0.setImageResource(R.drawable.download);
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSecondsRemaining--;
                if (mSecondsRemaining >= 0) {
                    tv3.setText(mSecondsRemaining + " seconds remaining");
                    new Handler().postDelayed(mRunnable, 1000);
                } else {
                    conclude();
                }
            }
        };
        mSecondsRemaining = 3;
        mRunnable.run();
    }

    protected void conclude() {
        if (getIntent().getBooleanExtra("reboot", false)) {
            log("simulate perform upgrade: simulate upgrade by invoking reboot now");
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            pm.reboot(null);
        } else {
            log("simulate perform upgrade: simulate upgrade halted/failed; return to Setup");
            setResult(RESULT_OK);
            finish();
        }
    }
}


