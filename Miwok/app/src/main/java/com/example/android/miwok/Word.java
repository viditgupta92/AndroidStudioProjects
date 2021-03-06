package com.example.android.miwok;

/**
 * Created by vidit on 7/19/2017.
 */

public class Word {
    String defaultTranslation = new String();
    String miwokTranslation = new String();
    Integer imageResourceId = NO_IMAGE;
    Integer audioResourceId;

    public static final Integer NO_IMAGE = -1;

    public Word(String eDefaultTranslation, String eMiwokTranslation, Integer eAudioResourceId)
    {
        defaultTranslation = eDefaultTranslation;
        miwokTranslation = eMiwokTranslation;
        audioResourceId = eAudioResourceId;
    }

    public Word(String eDefaultTranslation, String eMiwokTranslation, Integer eImageResourceId, Integer eAudioResourceId)
    {
        defaultTranslation = eDefaultTranslation;
        miwokTranslation = eMiwokTranslation;
        imageResourceId = eImageResourceId;
        audioResourceId = eAudioResourceId;
    }

    public String getDefaultTranslation()
    {
        return defaultTranslation;
    }

    public String getMiwokTranslation() { return miwokTranslation; }

    public Integer getImageResourceId(){
        return imageResourceId;
    }

    public Integer getAudioResourceId(){
        return audioResourceId;
    }

    public Boolean hasImage() {
        if(imageResourceId == NO_IMAGE){
            return false;
        }
        else{
            return true;
        }
    }
}
