package com.sven.viewtouchmeasure.anim;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.sven.viewtouchmeasure.R;

/**
 * Created by SVEN on 2018/1/31.
 */

public class AnimActivity extends Activity {
    private ImageView iv_hzw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        iv_hzw = (ImageView) findViewById(R.id.iv_hzw);



    }

    private void scale(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_hzw,"scaleY",1,0f, 1.5f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator(){
            @Override
            public float getInterpolation(float input) {
                return super.getInterpolation(input);
            }
        });
        objectAnimator.setDuration(500);
        objectAnimator.start();
        ValueAnimator.ofObject(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                return null;
            }
        });
    }


    public void onPush(View view){
        scale();
    }
}
