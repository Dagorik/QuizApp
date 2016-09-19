package com.dev.dagorik.realexamplebd.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dagorik on 14/09/2016.
 */
public class User extends RealmObject{

    private String name;
    @PrimaryKey
    private String email;

    private int edad;

    public User(String name, String email, int edad) {
        this.name = name;
        this.email=email;
        this.edad=edad;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", email='" + email + '\'' +
                ", edad=" + edad +
                '}';
    }
}
