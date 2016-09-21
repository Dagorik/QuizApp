package com.dev.dagorik.login.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;
import com.dev.dagorik.login.R;
import com.dev.dagorik.login.models.Users;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {


    private EditText username, password;
    private ActionProcessButton btnSignIn;
    private String pass, user;

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

    public void consultaSingIn(String user, String pass) {
        // Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getActivity()).build();
        Realm.setDefaultConfiguration(realmConfig);

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        List<Users> all= realm.where(Users.class).findAll();
        Users usuarios = realm.where(Users.class).equalTo("name", user).findFirst();


        String userbdd = usuarios.getName();
        String passs = usuarios.getpassword();


        Log.e("MyLogU", userbdd);
        Log.e("MyLogP", passs);


        if (user.equals(userbdd) && pass.equals(passs)) {
            Toast.makeText(getActivity(), "Bienvendio" + userbdd, Toast.LENGTH_SHORT).show();
            Log.i("Inicio de sesion", userbdd);

        }
    }


    @Override
    public void onClick(View view) {


        user = username.getText().toString();
        pass = password.getText().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getActivity(), "Tienes que llenar los datos", Toast.LENGTH_SHORT).show();


        } else {

            consultaSingIn(user, pass);

            //Boton Succeful
            btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);

            btnSignIn.setProgress(100);

            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);


        }


    }

}
