package com.dev.dagorik.login.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;
import com.dev.dagorik.login.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {


    private EditText username, password;
    private ActionProcessButton btnSignIn;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        btnSignIn = (ActionProcessButton) view.findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(this);


        return view;


    }

    @Override
    public void onClick(View view) {

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getActivity(), "Tienes que llenar los datos", Toast.LENGTH_SHORT).show();


        } else {


            //Boton Succeful
            btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);

            btnSignIn.setProgress(100);

            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);

            Toast.makeText(getActivity(), "Consultar con la base de datos.", Toast.LENGTH_SHORT).show();

        }


    }

}
