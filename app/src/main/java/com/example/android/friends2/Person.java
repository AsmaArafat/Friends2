package com.example.android.friends2;

import java.io.Serializable;

/**
 * Created by g on 16/03/2018.
 */

public class Person implements Serializable{


    public Person() {
    }

    public Person(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    private String mail;

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    /*private List<String> list = new ArrayList<String>();

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return (ArrayList<String>) list;
    }*/
}
