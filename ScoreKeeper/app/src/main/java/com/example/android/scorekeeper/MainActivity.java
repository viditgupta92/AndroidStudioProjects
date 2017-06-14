package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int GoalsForTeamA = 0;
    int GoalsForTeamB = 0;
    int FoulsForTeamA = 0;
    int FoulsForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayGoalsForTeamA(GoalsForTeamA);
        displayFoulsForTeamA(FoulsForTeamA);
        displayGoalsForTeamB(GoalsForTeamB);
        displayFoulsForTeamB(FoulsForTeamB);
    }

    public void updateGoalsForTeamA(View view) {
        GoalsForTeamA += 1;
        displayGoalsForTeamA(GoalsForTeamA);
    }

    public void updateFoulsForTeamA(View view) {
        FoulsForTeamA += 1;
        displayFoulsForTeamA(FoulsForTeamA);
    }

    public void updateGoalsForTeamB(View view) {
        GoalsForTeamB += 1;
        displayGoalsForTeamB(GoalsForTeamB);
    }

    public void updateFoulsForTeamB(View view) {
        FoulsForTeamB += 1;
        displayFoulsForTeamB(FoulsForTeamB);
    }

    public void displayGoalsForTeamA(int goals) {
        TextView goalView = (TextView) findViewById(R.id.team_a_goals);
        goalView.setText(String.valueOf(goals));
    }

    public void displayFoulsForTeamA(int fouls) {
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(String.valueOf(fouls));
    }

    public void displayGoalsForTeamB(int goals) {
        TextView goalView = (TextView) findViewById(R.id.team_b_goals);
        goalView.setText(String.valueOf(goals));
    }

    public void displayFoulsForTeamB(int fouls) {
        TextView foulView = (TextView) findViewById(R.id.team_b_fouls);
        foulView.setText(String.valueOf(fouls));
    }

    public void reset(View view)
    {
        GoalsForTeamA = 0;
        displayGoalsForTeamA(GoalsForTeamA);
        GoalsForTeamB = 0;
        displayGoalsForTeamB(GoalsForTeamB);
        FoulsForTeamA = 0;
        displayFoulsForTeamA(FoulsForTeamA);
        FoulsForTeamB = 0;
        displayFoulsForTeamB(FoulsForTeamB);
    }
}
