package com.dev.dagorik.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dev.dagorik.login.models.Users;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText et_usuario, et_password, et_edad;
    private Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_usuario= (EditText) findViewById(R.id.et_usuario);
        et_password= (EditText) findViewById(R.id.et_password);
        et_edad= (EditText) findViewById(R.id.et_edad);
        btn_registrar=(Button)findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(this);
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

       String usuarioFinal= et_usuario.getText().toString();
        String passwordFinal = et_password.getText().toString();
        String edadFInal = et_edad.getText().toString();
        int edadint= Integer.parseInt(edadFInal);

        Users user = new Users(usuarioFinal,passwordFinal,edadint);

        guardarUsuario(user);

    }
}
