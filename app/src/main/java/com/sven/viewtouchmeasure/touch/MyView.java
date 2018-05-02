package com.sven.viewtouchmeasure.touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sven.viewtouchmeasure.Vlog;

/**
 * Created by 11002252 on 2018/5/2.
 */

public class MyView extends View {
    private static final String TAG = "MyView";

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyView(Context context) {
        this(context, null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Vlog.i(TAG, "dispatchTouchEvent ..." + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Vlog.i(TAG, "onTouchEvent ..." + event.getAction());
        boolean result = false; //super.onTouchEvent(event);
        Vlog.i(TAG, "onTouchEvent result " + result);
        return result;
    }
}
