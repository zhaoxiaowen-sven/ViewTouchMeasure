package com.sven.viewtouchmeasure.measure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import com.sven.viewtouchmeasure.R;
import com.sven.viewtouchmeasure.Vlog;

public class MeasureActivity extends AppCompatActivity {
    private static final String TAG = "MeasureActivity";
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        view = findViewById(R.id.customeview);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            if (view != null){
                int height = view.getMeasuredHeight();
                int width = view.getMeasuredHeight();
                Vlog.i(TAG, "height = "+height + "width = "+width);
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (view != null){
            view.post(new Runnable() {
                @Override
                public void run() {
                    int height = view.getMeasuredHeight();
                    int width = view.getMeasuredHeight();
                    Vlog.i(TAG, "height2 = "+height + "width2 = "+width);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        ViewTreeObserver observer = view.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height = view.getMeasuredHeight();
                int width = view.getMeasuredHeight();
                Vlog.i(TAG, "height3 = "+height + "width3 = "+width);
            }
        });

    }
}
