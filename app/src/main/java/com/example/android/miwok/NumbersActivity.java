package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        final ArrayList<Word>words = new ArrayList<Word>();
        words.add(new Word("Lutti","One",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Otiiko","Two",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Tolookosu","Three",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Oyyisa","Four",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Massoka","Five",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Temmokka","Six",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("Kenekaku","Seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("Kawinta","Eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("Wo'e","Nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("Na'aacha","Ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_numbers);

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
                mediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getaudio());
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

