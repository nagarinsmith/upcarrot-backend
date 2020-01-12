package com.upcarrot.UpCarrot.Model;

import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document("expense-borrowed")
@Data
public class ExpenseBorrowed extends BaseEntity {
    @Field
    private String user;
    @Field
    private String description;
    @Field
    private Double total;
    @Field
    private ExpenseCategory category;
    @Field
    private Date date;
    @Field
    private String otherParticipant;
    @Field
    private Status status;

    public ExpenseBorrowed(String user, @Nullable String description, Double total, ExpenseCategory category, Date date, @Nullable String otherParticipant, Status status) {
        this.user = user;
        this.description = description;
        this.total = total;
        this.category = category;
        this.date = date;
        this.otherParticipant = otherParticipant;
        this.status = status;
    }

    public ExpenseBorrowed() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
