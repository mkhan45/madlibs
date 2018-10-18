package com.example.a2020mkhan.madlibs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class listFragment extends Fragment {

    public listFragment(){

    }

    public static listFragment newInstance() {
        listFragment fragment = new listFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.story_list, container, false);
        LinearLayout ll = rootView.findViewById(R.id.linear);
            for (int i = 0; i < ll.getChildCount(); i++){
                View v = ll.getChildAt(i);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = "abc %1$s %2$s %3$s";
                        String[] words = {"bc", "asdf", "lkji"};
                        inputFragment inputFrag = new inputFragment(words);
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.frame, inputFrag).addToBackStack(null).commit();
                    }
                });
            }
        return rootView;
    }

}
