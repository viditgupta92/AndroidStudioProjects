package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mp;

    private AudioManager am;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();;
        }
    };

    private AudioManager.OnAudioFocusChangeListener  mFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mp.pause();
                mp.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mp.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mp.stop();
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two","otiiko",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three","tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four","oyyisa",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five","massokka",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six","temmokka",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven","kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight","kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine","wo’e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten","na’aacha",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = words.get(position);

                releaseMediaPlayer();

                int result = am.requestAudioFocus(mFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    mp = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                    mp.start();

                    mp.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
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

            am.abandonAudioFocus(mFocusChangeListener);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }
}
