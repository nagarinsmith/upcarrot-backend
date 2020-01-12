package com.upcarrot.UpCarrot.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document("event")
@Data
public class Event extends BaseEntity {

    @Field
    private List<User> listOfUsers;

    @Field
    private List<ExpenseBorrowed> listOfExpenses;

    @Field
    private String name;

    @Field
    private Date date;

    @Field
    private Status status;

    public Event(List<User> listOfUsers, List<ExpenseBorrowed> listOfExpenses, String name, Date date, Status status) {
        this.listOfUsers = listOfUsers;
        this.listOfExpenses = listOfExpenses;
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public Event() {
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public List<ExpenseBorrowed> getListOfExpenses() {
        return listOfExpenses;
    }

    public void setListOfExpenses(List<ExpenseBorrowed> listOfExpenses) {
        this.listOfExpenses = listOfExpenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
