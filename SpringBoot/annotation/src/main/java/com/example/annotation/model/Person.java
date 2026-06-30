package com.example.annotation.model;

import com.example.annotation.annotations.SerializerMethod;
import com.example.annotation.annotations.SerializerType;

import java.time.LocalDate;

import static com.example.annotation.annotations.FieldFormatEnum.KEBAB_CASE;

@SerializerType(fieldFormat = KEBAB_CASE, pretify = false)
public class Person {
    private long id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @SerializerMethod("firtsPersonName")
    public String firtName(){
        return name.split(" ")[0];
    }

}
