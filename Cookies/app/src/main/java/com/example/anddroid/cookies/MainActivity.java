package com.example.anddroid.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("EnterpriseActivity.java", "Captain's Log, Stardate 43125.8. We have entered a spectacular binary star system in the Kavis Alpha sector on a most critical mission of astrophysical research.");
        setContentView(R.layout.activity_main);

    }
    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {

        // toDo   : Find a reference to the ImageView in the layout. Change the image.
        ImageView img= (ImageView) findViewById(R.id.android_cookie_image_view);
        img.setImageResource(R.drawable.after_cookie);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView tv= (TextView) findViewById(R.id.status_text_view);
        tv.setText("I'm so full");

    }
}
