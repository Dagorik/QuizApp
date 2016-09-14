package com.dev.dagorik.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.dagorik.quizapp.R;

public class ResultadoFragment extends Fragment {

    private String user;
    private int resultado;

    public ResultadoFragment(String user, int resultado) {
        this.user = user;
        this.resultado = resultado;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        TextView tvUser = (TextView) view.findViewById(R.id.tvUser);
        TextView tv_resultado = (TextView) view.findViewById(R.id.tv_resultado);

        tvUser.setText(user);
        tv_resultado.setText(resultado + "");

        return view;


    }

}
