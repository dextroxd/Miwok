package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

        private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange ==
                            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
                    {
                        mediaPlayer.stop();
                        releaseMediaplayer();

                    }

                    else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
                    {
                        mediaPlayer.start();
                    }
                }
            };
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.words_list);
            mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("Weṭeṭṭi","Red",R.drawable.color_red,R.raw.color_red));
            words.add(new Word("Chokokki","Green",R.drawable.color_green,R.raw.color_green));
            words.add(new Word("Takaakki","Brown",R.drawable.color_brown,R.raw.color_brown));
            words.add(new Word("Topoppi","Gray",R.drawable.color_gray,R.raw.color_gray));
            words.add(new Word("Kululi","Black",R.drawable.color_black,R.raw.color_black));
            words.add(new Word("Kelelli","White",R.drawable.color_white,R.raw.color_white));
            words.add(new Word("Topiisә","Dusty Yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
            words.add(new Word("Chiwiiṭә","Mustard Yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
            WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_colors);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Word word = words.get(position);
                    releaseMediaplayer();

                    int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);


                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer = MediaPlayer.create(ColorsActivity.this,word.getaudio());
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                releaseMediaplayer();
                            }
                        });
                    }


                }
            });
        }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaplayer();
    }
    private  void releaseMediaplayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
}
