package com.upcarrot.UpCarrot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("personExpense")
public class PersonExpense {
    @Id
    private String id;
    private Expense expense;
    private Person person;

    public PersonExpense(String id, Expense expense, Person person){
        this.id = id;
        this.expense = expense;
        this.person = person;
    }
    public String getId() {
        return id;
    }

    public Expense getExpense() {
        return expense;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
