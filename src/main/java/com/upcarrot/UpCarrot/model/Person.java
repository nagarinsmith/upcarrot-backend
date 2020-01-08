package com.upcarrot.UpCarrot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("person")
public class Person {
    @Id
    private String phoneNumber;
    private String name;

    public Person(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
    public Person(){
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
