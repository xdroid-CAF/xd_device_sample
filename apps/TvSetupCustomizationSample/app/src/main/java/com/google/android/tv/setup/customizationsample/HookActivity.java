package com.google.android.tv.setup.customizationsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class HookActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iv0.setVisibility(View.VISIBLE);
        iv0.setImageResource(R.drawable.hook);

        btn0.setVisibility(View.VISIBLE);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAboutToFinish();
                finish();
            }
        });
    }

    protected void onAboutToFinish() {
        setResult(Activity.RESULT_OK);
    }
}
