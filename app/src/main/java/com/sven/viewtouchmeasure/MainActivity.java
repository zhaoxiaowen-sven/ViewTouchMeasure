package com.sven.viewtouchmeasure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sven.viewtouchmeasure.anim.AnimActivity;
import com.sven.viewtouchmeasure.measure.MeasureActivity;
import com.sven.viewtouchmeasure.touch.TouchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        switch (v.getId()) {
        case R.id.bt1:
            Intent intent1 = new Intent(this, TouchActivity.class);
            startActivity(intent1);
            break;
        case R.id.bt2:
            Intent intent2 = new Intent(this, MeasureActivity.class);
            startActivity(intent2);
            break;
        case R.id.bt3:
            Intent intent3 = new Intent(this, AnimActivity.class);
            startActivity(intent3);
            break;
        }
    }
}
