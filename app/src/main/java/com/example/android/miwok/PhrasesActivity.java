package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going));
        words.add(new Word("Tinnә oyaase'nә","What is your name?",R.raw.phrase_what_is_your_name));
        words.add(new Word("Oyaaset...","My name is...",R.raw.phrase_my_name_is));
        words.add(new Word("Michәksәs?","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Kuchi achit","I’m feeling good.",R.raw.phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?","Are you coming?",R.raw.phrase_are_you_coming));
        words.add(new Word("Hәә’ әәnәm","Yes, I’m coming.",R.raw.phrase_yes_im_coming));
        words.add(new Word("әәnәm","I’m coming.",R.raw.phrase_im_coming));
        words.add(new Word("Yoowutis","Let’s go.",R.raw.phrase_lets_go));
        words.add(new Word("әnni'nem","Come here.",R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getaudio());
                mediaPlayer.start();
            }
        });
    }
}
