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
public class SkillsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instance_list, container, false);

        final ArrayList<Instance> instances = new ArrayList<Instance>();
        instances.add(new Instance("Languages","C, C++, C#, Python, Java, SQL"));
        instances.add(new Instance("Web Technologies","HTML, CSS, JavaScript, Bootstrap, AngularJS, Node.js, Heroku"));
        instances.add(new Instance("Databases:","MySQL, MongoDB"));
        instances.add(new Instance("Operating Systems:","QNX, Unix, Windows 2000/XP/Vista/7/8/10"));
        instances.add(new Instance("Applications:","Pycharm, Android Studio, Visual Studio, IntelliJ, WebStorm, Git, MATLAB, Racket"));

        SkillsAdapter adapter = new SkillsAdapter(getActivity(),instances,R.color.category_skills);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
