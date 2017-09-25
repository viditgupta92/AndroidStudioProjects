package com.example.android.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp = MediaPlayer.create(this, R.raw.song);
    private AudioManager am = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
        }
    }

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Context context = getApplicationContext();
            CharSequence text = "Song finished playing";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playB = (Button) findViewById(R.id.play);
        Button pauseB = (Button) findViewById(R.id.pause);
        Button increaseB = (Button) findViewById(R.id.volume_up);
        Button decreaseB = (Button) findViewById(R.id.volume_down);

        playB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //releaseMediaPlayer();
                mp.start();
                mp.setOnCompletionListener(mCompletionListener);
            }
        });

        pauseB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.pause();
            }
        });

        increaseB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                am.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        decreaseB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                am.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });
    }
}
