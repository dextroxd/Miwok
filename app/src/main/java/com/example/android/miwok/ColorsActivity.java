package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.words_list);
            ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("Weṭeṭṭi","Red"));
            words.add(new Word("Chokokki","Green"));
            words.add(new Word("Takaakki","Brown"));
            words.add(new Word("Topoppi","Gray"));
            words.add(new Word("Kululi","Black"));
            words.add(new Word("Kelelli","White"));
            words.add(new Word("Topiisә","Dusty Yellow"));
            words.add(new Word("Chiwiiṭә","Mustard Yellow"));
            WordAdapter itemsAdapter = new WordAdapter(this, words);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(itemsAdapter);
    }
}
