package com.auribises.gwaactivitydemo;

import java.io.Serializable;

/**
 * Created by ishantkumar on 05/07/17.
 */

public class Person implements Serializable{

    // Attributes
    private String name;
    private String phone;
    private int age;

    public Person(){

    }

    public Person(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
