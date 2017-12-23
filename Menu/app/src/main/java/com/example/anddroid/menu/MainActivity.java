package com.example.anddroid.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printToLogs(View view) {

        // Find second menu item TextView and print the text to the logs
        TextView tv1 = (TextView) findViewById(R.id.menu_item_1);
        String s1= (String) tv1.getText();
        Log.v("menu item 1",s1);

        // Find first menu item TextView and print the text to the logs
        TextView tv2 = (TextView) findViewById(R.id.menu_item_2);
        String s2= (String) tv2.getText();
        Log.v("menu item 2",s2);


        // Find third menu item TextView and print the text to the logs
        TextView tv3 = (TextView) findViewById(R.id.menu_item_3);
        String s3= (String) tv3.getText();
        Log.v("menu item 3",s3);

    }
}
