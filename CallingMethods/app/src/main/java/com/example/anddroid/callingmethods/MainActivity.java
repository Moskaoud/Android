package com.example.anddroid.callingmethods;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.anddroid.callingmethods.R.color.mostafaColor;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv=new TextView(this);
        tv.setText("Mostafa Mohamed ");
        tv.setTextColor(getResources().getColor(mostafaColor));
        tv.setTextColor(Color.parseColor("#FF00FF"));
        tv.setTextColor(Color.RED);
        tv.setTextSize(77);
        //    setContentView(tv);
        //setContentView(R.layout.activity_main);
    }
}
