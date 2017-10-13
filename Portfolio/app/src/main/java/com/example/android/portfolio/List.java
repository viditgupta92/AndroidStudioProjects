package com.example.android.portfolio;

/**
 * Created by vidit on 10/12/2017.
 */

public class List {
    Integer imageResourceId = NO_IMAGE;
    String title;
    String description;

    public static final Integer NO_IMAGE = -1;

    public List(Integer eImageResourceId, String eTitle)
    {
        imageResourceId = eImageResourceId;
        title = eTitle;
    }

    public List(Integer eImageResourceId, String eTtile, String eDescription){
        imageResourceId = eImageResourceId;
        title = eTtile;
        description = eDescription;
    }
}
