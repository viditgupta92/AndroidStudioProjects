package com.example.android.portfolio;

/**
 * Created by vidit on 10/12/2017.
 */

public class Instance {

    String heading;
    Integer imageResourceId = NO_IMAGE;
    String title;
    String subTitle;
    String description;

    public static final Integer NO_IMAGE = -1;

    public Instance(Integer eImageResourceId, String eHeading,  String eTitle)
    {
        imageResourceId = eImageResourceId;
        heading = eHeading;
        title = eTitle;
    }

    public Instance(String eHeading, String eTitle, String eDescription){
        heading = eHeading;
        title = eTitle;
        description = eDescription;
    }

    public Instance(Integer eImageResourceId, String eHeading, String eTitle, String eSubTitle, String eDescription){
        imageResourceId = eImageResourceId;
        heading = eHeading;
        title = eTitle;
        subTitle = eSubTitle;
        description = eDescription;
    }

    public String getHeading()
    {
        return heading;
    }

    public String getTitle()
    {
        return title;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public String getDescription() { return description; }

    public Integer getImageResourceId(){
        return imageResourceId;
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
