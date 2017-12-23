package com.example.anddroid.coutcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0 ;
    int scoreTeamB=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayForTeamA(int score)
    {
        TextView tv=(TextView) findViewById(R.id.team_a_score);
        tv.setText(score+"");
    }
    public void addThreeForTeamA(View  v)
    {
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }
    public void addTwoForTeamA(View v)
    {
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);

    }
    public void addOneForTeamA(View v)
    {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }

    // Tream B
    public void displayForTeamB(int score)
    {
        TextView tv=(TextView) findViewById(R.id.team_b_score);
        tv.setText(score+"");
    }
    public void addThreeForTeamB(View  v)
    {
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    public void addTwoForTeamB(View v)
    {
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);

    }
    public void addOneForTeamB(View v)
    {
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View v)
    {
        scoreTeamA=scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

}
