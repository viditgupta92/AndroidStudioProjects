package com.example.android.portfolio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instance_list, container, false);

        final ArrayList<Instance> instances = new ArrayList<Instance>();
        instances.add(new Instance(R.drawable.neu_logo, "Education","Northeastern University","Masters in Computer Science","Courses: Algorithms, Web Development, Information Retrieval, Programming Design Paradigms"));
        instances.add(new Instance(R.drawable.vit_logo,  "Education", "Vellore Institute of Technology","Bachelors in Electronics and Communication Engineering","Courses: Algorithms, Web Development, Information Retrieval, Programming Design Paradigms"));

        EducationAdapter adapter = new EducationAdapter(getActivity(),instances,R.color.category_education);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
