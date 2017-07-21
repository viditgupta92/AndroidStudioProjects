package com.example.android.miwok;

/**
 * Created by vidit on 7/19/2017.
 */

public class Word {
    String defaultTranslation = new String();
    String miwokTranslation = new String();

    public Word(String eDefaultTranslation, String eMiwokTranslation)
    {
        defaultTranslation = eDefaultTranslation;
        miwokTranslation = eMiwokTranslation;
    }

    public String getDefaultTranslation()
    {
        return defaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return miwokTranslation;
    }
}
