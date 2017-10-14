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
public class WorkExpFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instance_list, container, false);

        final ArrayList<Instance> instances = new ArrayList<Instance>();
        instances.add(new Instance(R.drawable.lam_logo,"Lam Research","Tualatin, OR", "Software Developer Intern","May'17 - Present","Working on new software requests for Sabre3D deposition tool based on client requests, with back-end development in Java,\n" +
                "C++ and front-end in C# along with resolving key software issues by debugging code."));
        instances.add(new Instance(R.drawable.neu_logo,"Northeastern University","Boston, MA", "Graduate Teaching Assistant","Jan'17 - Apr'17","Guided undergraduate students in the Discrete Structures course by catering to their doubts pertaining to the coursework and helping instructor\n" +
                "by taking lectures, recitations, grading assignments and exam papers."));
        instances.add(new Instance(R.drawable.lam_logo,"Lam Research","Bangalore, India", "Software Engineer 2","July'14 - Aug'16","• Proficient in requirement collection, designing and implementing of the control system software and white box unit testing.\n" +
                "• Resolved critical software issues faced in client’s wafer fabrication facility which hampered production, by debugging code\n" +
                "and improving the architecture design and in turn reducing the UI response time.\n" +
                "• Trained for 2 weeks at client’s wafer fabrication facility in Taiwan for product knowledge and gaining hands-on experience."));
        instances.add(new Instance(R.drawable.tata_logo,"Tata Teleservices Limited","New Delhi, India", "Summer Intern","May'12 - June'12","Implemented project “Basics of Switching Technology”, collaborating the voice and data transmission techniques used by the OMC (Operations, Maintenance & Control) department, tracing call location requests and handling customer complaints."));

        WorkExpAdapter adapter = new WorkExpAdapter(getActivity(),instances,R.color.category_workexp);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
