package com.example.a2020mkhan.madlibs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class storyFragment extends android.support.v4.app.Fragment {

    String[] words;
    String story;
    public storyFragment(String[] w, String s){
        words = w;
        story = s;
    }

    public storyFragment(story s){
        story = s.getStory();
        words = s.getWords();
    }

    public static storyFragment newInstance(String[] w, String s){
        storyFragment fragment = new storyFragment(w, s);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.story_fragment, container, false);
        TextView tv = rootView.findViewById(R.id.story);
        tv.setText(String.format(story, words));
        tv.setTextSize(20);
        return rootView;
    }

}
