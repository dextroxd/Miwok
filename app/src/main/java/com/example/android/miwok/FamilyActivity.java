package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("әpә","Father"));
        words.add(new Word("әṭa","Mother"));
        words.add(new Word("Angsi","Son"));
        words.add(new Word("Tune","Daughter"));
        words.add(new Word("Taachi","Older Brother"));
        words.add(new Word("Chalitti","Younger Brother"));
        words.add(new Word("Teṭe","Older Sister"));
        words.add(new Word("Kolliti","Younger Sister"));
        words.add(new Word("Ama","Grandmother"));
        words.add(new Word("Paapa","Grandfather"));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);}
}
