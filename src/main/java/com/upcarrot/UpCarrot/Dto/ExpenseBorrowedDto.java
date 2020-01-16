package com.upcarrot.UpCarrot.Dto;

import com.mongodb.lang.Nullable;
import com.upcarrot.UpCarrot.Model.BaseEntity;
import com.upcarrot.UpCarrot.Model.ExpenseCategory;
import com.upcarrot.UpCarrot.Model.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class ExpenseBorrowedDto extends BaseEntity {

    private String user;
    private String description;
    private Double total;
    private ExpenseCategory category;
    private String date;
    private String otherParticipant;
    private Status status;

    public ExpenseBorrowedDto(String user, @Nullable String description, Double total, ExpenseCategory category, String date, @Nullable String otherParticipant, Status status) {
        this.user = user;
        this.description = description;
        this.total = total;
        this.category = category;
        this.date = date;
        this.otherParticipant = otherParticipant;
        this.status = status;
    }

    public ExpenseBorrowedDto() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOtherParticipant() {
        return otherParticipant;
    }

    public void setOtherParticipant(String otherParticipant) {
        this.otherParticipant = otherParticipant;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
