package com.example.a2020mkhan.madlibs;

import android.support.v4.app.*;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    public MainActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFragment mainFrag = new listFragment(new ArrayList<story>());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setTransition(R.anim.enter);
        transaction.replace(R.id.frame, mainFrag).commit();
    }


}
