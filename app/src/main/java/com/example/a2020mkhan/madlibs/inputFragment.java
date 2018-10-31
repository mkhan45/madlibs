package com.example.a2020mkhan.madlibs;

import android.support.v4.app.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class inputFragment extends Fragment {

    String[] types;
    story story;
    public inputFragment(story s){
        types = s.getTypes();
        story = s;
    }
    public static inputFragment newInstance(String[] t) {
        com.example.a2020mkhan.madlibs.story s = new story("title", "", t);
        inputFragment fragment = new inputFragment(s);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.input_frag, container, false);
        final LinearLayout ll = rootView.findViewById(R.id.linear);
        for (int i = 0; i < types.length; i++){
            EditText et = new EditText(getContext());
            et.setHint(types[i]);
            ll.addView(et);
        }
        Button save = new Button(getContext());
        save.setText("Save");
        ll.addView(save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make array of values and save to sharedPreferences
                String[] words = new String[ll.getChildCount()];
                for (int i = 0; i < ll.getChildCount(); i++){
                    TextView tv = (TextView) ll.getChildAt(i);
                    words[i] = tv.getText().toString();
                    story.setWords(words);
                }

                storyFragment storyFrag = new storyFragment(story);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame, storyFrag).addToBackStack(null).commit();
            }
        });
        return rootView;
    }

}
