package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
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
                if(mediaPlayer!=null)
                {
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                mediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getaudio());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if(mediaPlayer != null)
                        {
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                    }
                });
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
