package com.example.a2020mkhan.madlibs;

import android.support.v4.app.*;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class inputFragment extends Fragment {

    String[] types;

    public inputFragment(String[] t){
        types = t;
    }

    public static inputFragment newInstance(String[] t) {
        inputFragment fragment = new inputFragment(t);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.input_frag, container, false);
        LinearLayout ll = rootView.findViewById(R.id.linear);
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
            }
        });
        return rootView;
    }

}
