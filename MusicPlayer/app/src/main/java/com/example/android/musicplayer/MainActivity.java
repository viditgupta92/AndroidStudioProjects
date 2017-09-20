package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playB = (Button) findViewById(R.id.play);
        Button pauseB = (Button) findViewById(R.id.pause);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.song);

        playB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp.start();
            }
        });

        pauseB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp.pause();
            }
        });
    }
}
