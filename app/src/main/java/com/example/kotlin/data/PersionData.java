package com.example.kotlin.data;

public class PersionData {
    public String name;
    public int age;
    public int id;

    public PersionData(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
