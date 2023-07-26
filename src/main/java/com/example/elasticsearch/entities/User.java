package com.example.elasticsearch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "user") // User class'ını elasticsearch ile uyumlu hale getirmek için document anotasyonunu kullanırız.
public class User {

    @Id
    private int id;
    @Field(type = FieldType.Text, name = "name") // elasticsearch'de, sql'de ki "column"a karşı gelen yapı field'dır.
    private String name;
    @Field(type = FieldType.Integer, name = "age")
    private int age;
    @Field(type = FieldType.Text, name = "gender")
    private String gender;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
