package com.dev.dagorik.login.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dagorik on 18/09/2016.
 */
public class Users extends RealmObject {
    private String name;
    @PrimaryKey
    private String password;

    private int edad;

    public Users(String name, String password, int edad) {
        this.name = name;
        this.password=password;
        this.edad=edad;
    }

    public Users(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String email) {
        this.password = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", edad=" + edad +
                '}';
    }
}


