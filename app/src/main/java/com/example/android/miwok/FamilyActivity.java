package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("әpә","Father",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("әṭa","Mother",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("Angsi","Son",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("Tune","Daughter",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("Taachi","Older Brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("Chalitti","Younger Brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("Teṭe","Older Sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("Kolliti","Younger Sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("Ama","Grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("Paapa","Grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
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
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getaudio());
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
