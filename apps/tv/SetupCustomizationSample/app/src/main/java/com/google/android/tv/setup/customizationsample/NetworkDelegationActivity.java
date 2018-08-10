package com.google.android.tv.setup.customizationsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * A network delegation Activity, which simulates presenting a get-me-connected user interface.
 */
public class NetworkDelegationActivity extends BaseActivity {

    public static final int RESULT_CODE_USER_SKIPPED = 3;
    boolean mHeardKey;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv1.setText("Press CENTER to pretend we just set up the network; press RIGHT to skip; press BACK to back out");
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!mHeardKey && keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            mHeardKey = true;
            setResult(Activity.RESULT_OK);
            finish();
            return true;
        }
        if (!mHeardKey && keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            mHeardKey = true;
            setResult(RESULT_CODE_USER_SKIPPED);
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED, new Intent().putExtra("user_initiated", true));
        finish();
    }
}


