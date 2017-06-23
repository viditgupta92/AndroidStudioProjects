package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        // Find first menu item TextView and print the text to the logs
        TextView text1 = (TextView) findViewById(R.id.menu_item_1);
        Log.i("EnterpriseActivity.java", "Mango sorbet");
        // Find second menu item TextView and print the text to the logs
        TextView text2 = (TextView) findViewById(R.id.menu_item_2);
        Log.i("EnterpriseActivity.java", "Blueberry pie");
        // Find third menu item TextView and print the text to the logs
        TextView text3 = (TextView) findViewById(R.id.menu_item_3);
        Log.i("EnterpriseActivity.java", "Chocolate lava cake");

    }
}