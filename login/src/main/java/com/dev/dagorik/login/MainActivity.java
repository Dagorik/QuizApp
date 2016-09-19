package com.dev.dagorik.login;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dev.dagorik.login.fragments.BlankFragment;
import com.dev.dagorik.login.models.Users;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment();
        Users user = new Users("Raul", "123", 28);
        guardarUsuario(user);
        printUsuarios();
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

    private void printUsuarios() {

        // Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        List<Users> allUser = realm.where(Users.class).findAll();

        for (int i = 0; i < allUser.size(); i++) {
            Log.i("Lista de usuarios", "User: " + allUser.get(i));
        }
    }

}
