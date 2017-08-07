package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red","weṭeṭṭi"));
        words.add(new Word("Green","chokokki"));
        words.add(new Word("Brown","ṭakaakki"));
        words.add(new Word("Gray","ṭopoppi"));
        words.add(new Word("Black","kululli"));
        words.add(new Word("White","kelelli"));
        words.add(new Word("Dusty yellow","ṭopiisә"));
        words.add(new Word("Mustard yellow","chiwiiṭә"));

        WordAdapter adapter = new WordAdapter(this,words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
