package com.dev.dagorik.quizapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dev.dagorik.quizapp.fragments.QuestionFragment;
import com.dev.dagorik.quizapp.fragments.ResultadoFragment;

import java.util.ArrayList;
import java.util.List;


public class StarQuizActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> mListPreguntas = new ArrayList<>();
    private List<Integer> mListRespuestas = new ArrayList<>();
    private QuestionFragment questionFragment;
    private ImageView iv_left, iv_right;

    private int questionPosition = 0;
    private int respuestasCorrectas = 0;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_quiz);

        initView();
        initPreguntas();
        initRespuestas();
        cambiarFragment(questionPosition);

        //Tomar los datos de una actividad atras
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            user = extras.getString("user");
        }
    }

    private void cambiarFragment(int position) {

        questionFragment = new QuestionFragment(mListPreguntas.get(position));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit)
                .replace(R.id.frameLayaut, questionFragment)
                .commit();

    }

    private void initPreguntas() {
        mListPreguntas.add("¿Chevrolet es autor del Chevelle?");
        mListPreguntas.add("¿Ford tiene el motor 350?");
        mListPreguntas.add("¿Mopar es mejor que los chevys?");
        mListPreguntas.add("¿SuperSport es de Chevrolet?");
        mListPreguntas.add("¿Charger es Mopar?");
        mListPreguntas.add("¿Existe barracuda SS?");
        mListPreguntas.add("¿El mejor motor de ford es el 351?");
        mListPreguntas.add("¿Big block es considerado desde el 400?");
        mListPreguntas.add("¿Slan-Six es de Chevrolet?");
    }

    private void initRespuestas() {
        mListRespuestas.add(1);
        mListRespuestas.add(0);
        mListRespuestas.add(0);
        mListRespuestas.add(1);
        mListRespuestas.add(1);
        mListRespuestas.add(0);
        mListRespuestas.add(1);
        mListRespuestas.add(1);
        mListRespuestas.add(0);

    }

    private void initView() {
        //Declarando
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);

        //El escuchador de los botones
        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);
    }

    private void FragmentFinal() {

        ResultadoFragment resultadoFragment = new ResultadoFragment(user, respuestasCorrectas);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit)
                .replace(R.id.frameLayaut, resultadoFragment)
                .commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_left:
                if (questionPosition >= 0) {
                    cambiarFragment(questionPosition--);
                    if (questionPosition < 0) {
                        questionPosition = 0;
                    }
                } else
                    Toast.makeText(StarQuizActivity.this, "No puedes ir mas atras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_right:
                if (questionPosition == mListPreguntas.size() - 1) {
                    FragmentFinal();
                } else {
                    if (questionFragment.getRespuesta() == mListRespuestas.get(questionPosition)) {
                        respuestasCorrectas++;
                    }
                    questionPosition++;
                    cambiarFragment(questionPosition);
                }

                break;

        }
    }
}
