package com.example.android.portfolio;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vidit on 7/20/2017.
 */

public class SkillsAdapter extends ArrayAdapter<Instance> {

    private int colorResourceId;

    public SkillsAdapter(Activity context, ArrayList<Instance> instances, int colorId) {
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
                    R.layout.list_skills, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Instance currentInstance = getItem(position);

        Log.v("Fragment","current instance: " + currentInstance);

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

        // Find the TextView in the list_educationation.xml layout with the ID version_number
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        descriptionTextView.setText(currentInstance.getDescription());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
