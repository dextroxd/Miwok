package com.example.android.miwok;

public class Word
{
    private String Miwokwords;
    private String Englishwords;
    public  Word(String text,String text1)
    {
        Miwokwords = text;
        Englishwords = text1;
    }

    public  String get_miwok_Text()
    {
        return (Miwokwords);
    }

    public String get_english_Text()
    {
        return Englishwords;
    }
}
