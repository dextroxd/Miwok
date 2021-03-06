package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private  int col;

    public WordAdapter(Context context, ArrayList<Word> word,int color) {
        super(context, 0, word);
        col = color;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Word w = getItem(position);
        View lv =  listItemView.findViewById(R.id.listitem);

        int colo = ContextCompat.getColor(getContext(),col);
        lv.setBackgroundColor(colo);
        TextView tv = (TextView) listItemView.findViewById(R.id.Miwok);
        tv.setText(w.get_miwok_Text());
        TextView tv2 = (TextView)listItemView.findViewById(R.id.English);
        tv2.setText(w.get_english_Text());
        ImageView iv = (ImageView) listItemView.findViewById(R.id.image_view);
        if(w.hasImage())
        {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(w.getResource_id());
        }
        else
        {
         iv.setVisibility(View.GONE);
        }
        return listItemView;
    }
}