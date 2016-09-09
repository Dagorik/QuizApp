package com.dev.dagorik.quizapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dev.dagorik.quizapp.fragments.QuestionFragment;

public class StarQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_quiz);

        QuestionFragment questionFragment= new QuestionFragment("¿De a como?");

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayaut,questionFragment)
                .commit();

    }


}
