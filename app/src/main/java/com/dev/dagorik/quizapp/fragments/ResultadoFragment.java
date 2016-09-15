package com.dev.dagorik.quizapp.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        //Obtener datos por el SharendPreferences
        SharedPreferences preferences = getActivity().getSharedPreferences("preferenciasQuiz", Context.MODE_PRIVATE);
        String username = preferences.getString("user", "ÑO");
        int random = preferences.getInt("random",0);

        //Obtener datos por el putextra
        tvUser.setText(user);
        tv_resultado.setText(resultado + "");

        //Mostrando los dato obetenidos del shared preferences
        Toast.makeText(getActivity(),"Random: " + random +"User name por preferences: " +username, Toast.LENGTH_LONG).show();

        return view;


    }

}
