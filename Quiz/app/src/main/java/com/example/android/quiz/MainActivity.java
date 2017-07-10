package com.example.android.quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    HashMap<String,String> map= new HashMap<String,String>();

    public MainActivity()
    {
        map.put("animals_1","animals_1_c");
        map.put("animals_2","animals_2_b");
        map.put("science_1","science_1_d");
        map.put("science_2","science_2_a");
        map.put("technology_1","technology_1_c");
        map.put("technology_2","technology_2_d");
        map.put("gk_1","gk_1_a");
        map.put("gk_2","gk_2_c");
        map.put("sports_1","sports_1_d");
        map.put("sports_2","sports_2_a");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluateOption(View view)
    {
        String selectedOptionName = view.getResources().getResourceName(view.getId());
        selectedOptionName = selectedOptionName.substring(selectedOptionName.lastIndexOf("/")+1);
        int lastIndexOf = selectedOptionName.lastIndexOf("_");
        String substring = selectedOptionName.substring(0, lastIndexOf);
        int resId = this.getResources().getIdentifier(map.get(substring), "id", this.getPackageName());
        Button correctButton = (Button) findViewById(resId);
        View correctView = (View) correctButton;
        Button selectedButton = (Button) view;
        if(correctView == view)
        {
            score += 10;
            selectedButton.setBackgroundColor(Color.GREEN);
        }
        else
        {
            selectedButton.setBackgroundColor(Color.RED);
        }
        TextView score_view = (TextView) findViewById(R.id.score);
        score_view.setText("" + score);
    }
}
