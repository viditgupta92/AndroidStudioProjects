package com.example.android.portfolio;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vidit on 7/20/2017.
 */

public class EducationAdapter extends ArrayAdapter<Instance> {

    private int colorResourceId;

    public EducationAdapter(Activity context, ArrayList<Instance> instances, int colorId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, instances);
        colorResourceId = colorId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_education, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Instance currentInstance = getItem(position);

        Log.v("Fragment","current instance: " + currentInstance);

        // Find the TextView in the list_education.xmln.xml layout with the ID version_name
        LinearLayout textView = (LinearLayout) listItemView.findViewById(R.id.text_view);
        // Find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        // Set background color of the text view container
        textView.setBackgroundColor(color);

        // Find the TextView in the list_educationation.xml layout with the ID version_name
        TextView headingTextView = (TextView) listItemView.findViewById(R.id.heading);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        headingTextView.setText(currentInstance.getHeading());

        // Find the TextView in the list_educationation.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        titleTextView.setText(currentInstance.getTitle());

        // Find the TextView in the list_education.xmln.xml layout with the ID version_name
        TextView subTitleTextView = (TextView) listItemView.findViewById(R.id.subTitle_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        subTitleTextView.setText(currentInstance.getSubTitle());

        // Find the TextView in the list_educationation.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentInstance.getDescription());

        // Find the ImageView in the list_educationation.xml layout with the ID version_number
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the version number from the current AndroidFlavor object

        if(currentInstance.hasImage()) {
            // set this text on the number TextView
            iconView.setImageResource(currentInstance.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }
        else{
            iconView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
