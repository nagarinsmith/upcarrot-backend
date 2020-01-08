package com.upcarrot.UpCarrot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("groupExpense")
public class GroupExpense {
    @Id
    private String id;
    private List<PersonContribution> contributions;
    private List<PersonExpense>  expenses;
    private Float total;
    private String description;

    public GroupExpense(String id, List<PersonContribution> contributions, List<PersonExpense> expenses, Float total, String description){
        this.id = id;
        this.contributions = contributions;
        this.expenses = expenses;
        this.total = total;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public List<PersonContribution> getContributions() {
        return contributions;
    }

    public List<PersonExpense> getExpenses() {
        return expenses;
    }

    public Float getTotal() {
        return total;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContributions(List<PersonContribution> contributions) {
        this.contributions = contributions;
    }

    public void setExpenses(List<PersonExpense> expenses) {
        this.expenses = expenses;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
