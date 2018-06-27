package com.google.android.tv.setup.customizationsample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseActivity extends Activity {

    protected ImageView iv0;
    protected Button btn0;
    protected TextView tv0;
    protected TextView tv1;
    protected TextView tv2;
    protected TextView tv3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_layout);

        iv0 = (ImageView)findViewById(R.id.image0);
        btn0 = (Button)findViewById(R.id.btn0);
        tv0 = (TextView)findViewById(R.id.tv0);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

        tv0.setText(getTitle());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdf.format(now);
        tv1.setText(strDate);
    }

    protected void log(String message) {
        Log.d(getPackageName(), message);
    }
}
