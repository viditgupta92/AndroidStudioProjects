package com.example.android.portfolio;

/**
 * Created by vidit on 10/12/2017.
 */

public class Instance {

    String heading;
    Integer imageResourceId = NO_IMAGE;
    String location;
    String title;
    String subTitle;
    String position;
    String duration;
    String languages;
    String description;

    public static final Integer NO_IMAGE = -1;

    public Instance(Integer eImageResourceId,  String eTitle)
    {
        imageResourceId = eImageResourceId;
        title = eTitle;
    }

    public Instance(String eTitle, String eDescription){
        title = eTitle;
        description = eDescription;
    }

    public Instance(Integer eImageResourceId, String eTitle, String eSubTitle, String eDescription){
        imageResourceId = eImageResourceId;
        title = eTitle;
        subTitle = eSubTitle;
        description = eDescription;
    }

    public Instance(Integer eImageResourceId, String eTitle, String eLocation, String ePosition, String eDuration, String eDescription){
        imageResourceId = eImageResourceId;
        location = eLocation;
        title = eTitle;
        position = ePosition;
        duration = eDuration;
        description = eDescription;
    }

    public Instance(String eTitle, String eLanguages, String eLocation, String eDuration, String eDescription){
        title = eTitle;
        languages = eLanguages;
        location = eLocation;
        duration = eDuration;
        description = eDescription;
    }

    public Instance(String eDescription){
        description = eDescription;
    }

    public String getTitle()
    {
        return title;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public String getPosition()
    {
        return position;
    }

    public String getDuration()
    {
        return duration;
    }

    public String getLocation()
    {
        return location;
    }

    public String getLanguages()
    {
        return languages;
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
