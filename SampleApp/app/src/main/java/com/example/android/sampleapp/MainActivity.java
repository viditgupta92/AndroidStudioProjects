package com.example.android.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity","onCreate");
    }

    protected void onStart(){
        super.onStart();
        Log.v("MainActivity","onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.v("MainActivity","onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.v("MainActivity","onPause");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.v("MainActivity","onDestroy");
    }
}
