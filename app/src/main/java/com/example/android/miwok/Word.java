package com.example.android.miwok;

import android.widget.ImageView;

public class Word
{
    private String Miwokwords;
    private String Englishwords;
    private int resource_id = NO_IMAGE_VALUE;
    private int audio;
    private static final int NO_IMAGE_VALUE = -1;
    public  Word(String text, String text1)
    {
        Miwokwords = text;
        Englishwords = text1;

    }
    public Word(String text,String text1,int id,int aud)
    {
        Miwokwords = text;
        Englishwords = text1;
        resource_id = id;
        audio = aud;
    }

    public  String get_miwok_Text()
    {
        return (Miwokwords);
    }
    public String get_english_Text()
    {
        return Englishwords;
    }
    public  int getResource_id(){ return  resource_id;}
    public  int getaudio(){ return  audio;}

    public boolean hasImage(){
        return resource_id!=NO_IMAGE_VALUE;
    }
}
