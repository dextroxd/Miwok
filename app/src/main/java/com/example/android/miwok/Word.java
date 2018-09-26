package com.example.android.miwok;

import android.widget.ImageView;

public class Word
{
    private String Miwokwords;
    private String Englishwords;
    private int resource_id;
    public  Word(String text, String text1)
    {
        Miwokwords = text;
        Englishwords = text1;

    }
    public Word(String text,String text1,int id)
    {
        Miwokwords = text;
        Englishwords = text1;
        resource_id = id;
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
}
