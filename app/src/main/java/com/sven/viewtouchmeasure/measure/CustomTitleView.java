package com.sven.viewtouchmeasure.measure;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.sven.viewtouchmeasure.R;

/**
 * Created by 11002252 on 2017/9/21.
 */

public class CustomTitleView extends View {

    private String mTitleText;

    private int mTitleTextColor;

    private int mTitleTextSize;

    private Rect mBound;

    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context, null);
    }



    public CustomTitleView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyle, 0);

        int n = a.getIndexCount();

        for(int i = 0; i<n; i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomTitleView_titleTextSize :
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
            }
        }
        a.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
    }
}
