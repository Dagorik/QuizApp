package com.dev.dagorik.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.dagorik.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private int position;

    public QuestionFragment(int position) {
        this.position = position;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);


        return view;
    }

}
