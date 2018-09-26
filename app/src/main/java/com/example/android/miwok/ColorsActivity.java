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
            words.add(new Word("Weṭeṭṭi","Red",R.drawable.color_red));
            words.add(new Word("Chokokki","Green",R.drawable.color_green));
            words.add(new Word("Takaakki","Brown",R.drawable.color_brown));
            words.add(new Word("Topoppi","Gray",R.drawable.color_gray));
            words.add(new Word("Kululi","Black",R.drawable.color_black));
            words.add(new Word("Kelelli","White",R.drawable.color_white));
            words.add(new Word("Topiisә","Dusty Yellow",R.drawable.color_dusty_yellow));
            words.add(new Word("Chiwiiṭә","Mustard Yellow",R.drawable.color_mustard_yellow));
            WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_colors);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(itemsAdapter);
    }
}
