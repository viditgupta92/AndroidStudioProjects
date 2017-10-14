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
public class ProjectsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instance_list, container, false);

        final ArrayList<Instance> instances = new ArrayList<Instance>();
        instances.add(new Instance("Miwok App","Java, Android Studio", "Personal Project", "May - Oct'17","Designed a multi-screen android application that allows users to learn Miwok language using English translation through list view, array adapters, intents, custom classes, activity lifecycle and audio playback."));
        instances.add(new Instance("Speak App","HTML, CSS, JavaScript, AngularJS, Node.js, MongoDB", "Web Development", "Jan - Apr'17","Designing a Speak App MEAN web application that connects people willing to learn a new foreign language with the native speakers using MVC architecture and CRUD operations."));
        instances.add(new Instance("Web App Maker","HTML, CSS, JavaScript, AngularJS, Node.js, MongoDB", "Web Development", "Jan - Apr'17","Designing a single page MEAN stack application to allow users to create websites, pages and widgets following responsive web design."));
        instances.add(new Instance("Search Engine","Python", "Information Retrieval", "Sept - Dec'16","Designed an indexer, retrieval system based on BM25, tf-idf and Cosine Similarity models. Query expansion techniques and evaluation of search engine was also performed based on precision and reciprocal rank measures."));
        instances.add(new Instance("Put module offline while system is running/executing","C, C#, Unix/Linux", "Lam Research", "Jan – July'17","Designed a new functionality and associated system architecture for allowing a request based mechanism for putting a module offline, estimating the time for satisfying the interlocks and automatically executing the request upon expiry."));
        instances.add(new Instance("Fan Filter Unit Monitoring System","C++, C#, Unix/Linux", "Lam Research", "Sept'14 - Apr'15","Designed a new UI interface to allow users to monitor differential pressure, fan rpm and face velocity data, collected from the embedded sensors in the fan filter unit hardware for increased efficiency and decreased response time."));

        ProjectsAdapter adapter = new ProjectsAdapter(getActivity(),instances,R.color.category_projects);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
