package com.upcarrot.UpCarrot.Dto;

import com.upcarrot.UpCarrot.Model.Event;
import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import com.upcarrot.UpCarrot.Model.User;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EventDTO {

    List<String> listOfUsers;
    List<ExpenseBorrowed> listOfExpenses;
    String name;
    String date;
    String status;


    public EventDTO() {
    }

    public EventDTO(List<String> listOfUsers, List<ExpenseBorrowed> listOfExpenses, String name, String date, String status) {
        this.listOfUsers = listOfUsers;
        this.listOfExpenses = listOfExpenses;
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public EventDTO(List<String> listOfUsers, String name, String date, String status) {
        this.listOfUsers = listOfUsers;
        this.listOfExpenses = new ArrayList<>();
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public EventDTO(Event event){
        this.listOfUsers = event.getListOfUsers().stream().map(User::getEmail).collect(Collectors.toList());
        this.listOfExpenses=event.getListOfExpenses();
        this.name=event.getName();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.date=formatter.format(event.getDate());
        this.status=event.getStatus().name().toUpperCase();
    }

    public List<String> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<String> listOfUsers) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
