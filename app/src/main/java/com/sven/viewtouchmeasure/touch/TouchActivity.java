package com.sven.viewtouchmeasure.touch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.sven.viewtouchmeasure.R;

public class TouchActivity extends AppCompatActivity {

    private static final String TAG = "TouchActivity";
    private MyView myView;
    private LinearLayout myLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        myView = (MyView) findViewById(R.id.myView);
        myLayout = (LinearLayout) findViewById(R.id.my_layout);

//        Log.i(TAG, "onCreate: " + this.getWindow().getDecorView());

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "onTouch: myLayout" + event.getAction());
                return false;
            }
        });
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "myView onClick");
            }
        });
        myView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG, "myView OnLongClick");
                return false;
            }
        });

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "myView onTouch: " + event.getAction());
                return false;
            }

        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "activity dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "activity onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);
    }


}
