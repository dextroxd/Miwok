package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Minto wuksus","Where are you going?",-1,R.raw.phrase_where_are_you_going));
        words.add(new Word("Tinnә oyaase'nә","What is your name?",-1,R.raw.phrase_what_is_your_name));
        words.add(new Word("Oyaaset...","My name is...",-1,R.raw.phrase_my_name_is));
        words.add(new Word("Michәksәs?","How are you feeling?",-1,R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Kuchi achit","I’m feeling good.",-1,R.raw.phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?","Are you coming?",-1,R.raw.phrase_are_you_coming));
        words.add(new Word("Hәә’ әәnәm","Yes, I’m coming.",-1,R.raw.phrase_yes_im_coming));
        words.add(new Word("әәnәm","I’m coming.",-1,R.raw.phrase_im_coming));
        words.add(new Word("Yoowutis","Let’s go.",-1,R.raw.phrase_lets_go));
        words.add(new Word("әnni'nem","Come here.",-1,R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
