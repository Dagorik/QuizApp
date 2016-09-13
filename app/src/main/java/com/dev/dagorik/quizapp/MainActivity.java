package com.dev.dagorik.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.user);
        btnIniciar=(Button)findViewById(R.id.btn_iniciar);

        btnIniciar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_iniciar:

                String usuario= user.getText().toString();
                if (usuario.isEmpty()){
                    Toast.makeText(this,"Ingresa un usuario", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(this,StarQuizActivity.class);
//                    Para enviar datos de a otra actividad
                    intent.putExtra("user",usuario);
                    startActivity(intent);
                }


            break;

        }

    }
}
