package com.example.a2020mkhan.madlibs;

import android.support.v4.app.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class listFragment extends Fragment {

    ArrayList<story> storyList;
    public listFragment(ArrayList<story> s){
        storyList = s;
        String[] types = {"noun", "verb"};
        story story = new story("Title", "abcd", types);
        s.add(story);
    }

    public static listFragment newInstance(ArrayList<story> s) {
        listFragment fragment = new listFragment(s);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.story_list, container, false);
        LinearLayout ll = rootView.findViewById(R.id.linear);
        Button newStory = new Button(getContext());
        newStory.setText("New Story");


        ArrayList<String> types = new ArrayList<>();
        String string = getResources().getString(R.string.story1);
        String[] words = string.split(" ");
        String tempString = "";
        for(String w : words) {
            if (w.startsWith("@")) {
                types.add(w.substring(1));
                w = "%s";
            }
            tempString += w + " ";
        }
        //put words in string
        storyList.get(0).setStory(tempString);
        storyList.get(0).setTypes(types.toArray(new String[9]));
        storyList.get(0).setTitle("Vacation");


        newStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        for (story s : storyList){
            TextView t = new TextView(getContext());
            t.setText(s.getTitle());
            t.setTextSize(30);
            t.setTag(s);
            ll.addView(t);
        }

         for (int i = 0; i < ll.getChildCount(); i++){
                View v = ll.getChildAt(i);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        story story = (story) view.getTag();
                        String title = story.getTitle();
                        String[] words = story.getTypes();
                        inputFragment inputFrag = new inputFragment(story);
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.frame, inputFrag).addToBackStack(null).commit();
                    }
                });
         }

        ll.addView(newStory);
        return rootView;
    }

}
