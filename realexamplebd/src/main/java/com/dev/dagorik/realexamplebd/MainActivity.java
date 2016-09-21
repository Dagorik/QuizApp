package com.dev.dagorik.realexamplebd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dev.dagorik.realexamplebd.models.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("Pedro", "pedro@gmail.com", 18);
        guardarUsuario(user);
        printUsuarios();

    }

    private void guardarUsuario(User user) {

        // Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.copyToRealmOrUpdate(user);

        realm.commitTransaction();

//        Log.i("myLog", user.toString());
    }

    private void printUsuarios() {


        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        List<User> allUser = realm.where(User.class).findAll();
        List<User> edad = realm.where(User.class).equalTo("edad",22).findAll();
        Log.e("Edad: ", "edades" + edad);

        for (int i = 0; i < allUser.size(); i++) {
            Log.i("Lista de usuarios", "User: " + allUser.get(i));
        }
    }


}
