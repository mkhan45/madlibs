package com.example.a2020mkhan.madlibs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class storyFragment extends Fragment {

    String[] words;
    String story;
    public storyFragment(String[] w, String s){
        words = w;
        story = s;
    }

    public static storyFragment newInstance(String[] w, String s){
        storyFragment fragment = new storyFragment(w, s);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.story_list, container, false);
        return rootView;
    }

}
