package com.dev.dagorik.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dev.dagorik.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {

    //Declarando
    private String title;
    private TextView tvTitle;
    private Button btn_true, btn_false;

    public QuestionFragment(String title) {
        this.title = title;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

//      Referenciando todo
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
//      Cambiando el titutlo de la pregunta
        tvTitle.setText(title);
        btn_true = (Button) view.findViewById(R.id.btn_true);
        btn_false = (Button) view.findViewById(R.id.btn_false);

//      Escuchando
        btn_false.setOnClickListener(this);
        btn_true.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_true:
                btn_true.setBackgroundResource(R.color.colorTrue);
                btn_false.setBackgroundResource(R.color.colorAmbar);
                break;

            case R.id.btn_false:
                btn_false.setBackgroundResource(R.color.colorFalse);
                btn_true.setBackgroundResource(R.color.colorAmbar);
                break;
        }
    }
}
