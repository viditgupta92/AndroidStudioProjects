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
public class AchievementsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instance_list, container, false);

        final ArrayList<Instance> instances = new ArrayList<Instance>();
        instances.add(new Instance("Winner of the HackNEU 2017 with the innovative idea of \"Food Finder\" which is a chrome extension that integrates with Facebook and suggests you places nearby where you get the same food item as posted by friends in their eating check-ins."));
        instances.add(new Instance("Developed ‘Maximum area coverage algorithm’, improving space optimization and coverage range by 25% compared to existing algorithms. Research paper titled \"Wireless Sensor node selection strategies for effective surveillance\" presented at Advance Computing Conference (IACC), 2015 IEEE International, Bangalore, 2015 and published in IEEE Xplore.    "));
        instances.add(new Instance("Event Co-ordinator and Organizer of BrainTeasers event in Gravitas'12, a 3 day cutural fest in college.It was an aptitude based quiz competition with sponsored prizes."));
        instances.add(new Instance("Receipent of CBSE Merit Scholarship for outstanding performance in Maths, Physics and Chemistry in 12th grade."));

        AchievementsAdapter adapter = new AchievementsAdapter(getActivity(),instances,R.color.category_achievements);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
