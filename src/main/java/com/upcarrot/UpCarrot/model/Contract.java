package com.upcarrot.UpCarrot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contract")
public class Contract {
    @Id
    private String id;
    private Person from;
    private Person to;
    private Float amount;
    private String description;

    public Contract(String id, Person from, Person to, Float amount, String description){
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public void setTo(Person to) {
        this.to = to;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }

    public Float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
