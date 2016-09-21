package com.dev.dagorik.login;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dev.dagorik.login.fragments.BlankFragment;
import com.dev.dagorik.login.models.Users;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BlankFragment blankFragment;
    private TextView tv_createUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment();
        Users user = new Users("Raul", "123", 28);
        guardarUsuario(user);

        tv_createUser = (TextView) findViewById(R.id.tv_createUser);


        tv_createUser.setOnClickListener(this);
    }

    public void fragment(){

        blankFragment = new BlankFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayaut,blankFragment)
                .commit();

    }

    private void guardarUsuario(Users user) {

        // Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.copyToRealmOrUpdate(user);

        realm.commitTransaction();

    }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);

    }
}
