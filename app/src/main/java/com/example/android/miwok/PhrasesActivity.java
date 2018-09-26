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
        words.add(new Word("Minto wuksus","Where are you going?"));
        words.add(new Word("Tinnә oyaase'nә","What is your name?"));
        words.add(new Word("Oyaaset...","My name is..."));
        words.add(new Word("Michәksәs?","How are you feeling?"));
        words.add(new Word("Kuchi achit","I’m feeling good."));
        words.add(new Word("әәnәs'aa?","Are you coming?"));
        words.add(new Word("Hәә’ әәnәm","Yes, I’m coming."));
        words.add(new Word("әәnәm","I’m coming."));
        words.add(new Word("Yoowutis","Let’s go."));
        words.add(new Word("әnni'nem","Come here."));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
