package com.example.android.reportcard;

/**
 * Created by vidit on 7/24/2017.
 */

public class ReportCard {

    private int englishMarks;
    private int mathsMarks;
    private int scienceMarks;

    public ReportCard()
    {
        
    }

    public void setEnglishMarks(int marks)
    {
        englishMarks = marks;
    }

    public void setMathsMarks(int marks)
    {
        mathsMarks = marks;
    }

    public void setScienceMarks(int marks)
    {
        scienceMarks = marks;
    }

    public int getEnglishMarks()
    {
        return englishMarks;
    }

    public int getMathsMarks()
    {
        return mathsMarks;
    }

    public int getScienceMarks()
    {
        return scienceMarks;
    }
}
