package com.sven.viewtouchmeasure.touch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sven.viewtouchmeasure.R;

public class TouchActivity extends AppCompatActivity {

    private static final String TAG = "TouchActivity";
    private Button bt;
    private LinearLayout myLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        bt = (Button) findViewById(R.id.bt);
        myLayout = (LinearLayout) findViewById(R.id.my_layout);


        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "onTouch: myLayout");
                return true;
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: bt...");
            }
        });

        bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "onTouch: " + event.getAction());
                return false;
            }
        });


    }
}
