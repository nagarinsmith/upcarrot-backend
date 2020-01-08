package com.upcarrot.UpCarrot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("expense")
public class Expense {
    @Id
    private String id;
    private String date;
    private Float total;
    private Tag tag;
    private String description;
    private List<Product> products;

    public Expense(String id, String date, Float total, Tag tag, String description, List<Product> products)
    {
        this.id = id;
        this.date = date;
        this.total = total;
        this.tag = tag;
        this.description = description;
        this.products = products;
    }
    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Float getTotal() {
        return total;
    }

    public Tag getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public List<Product> getProducts() {
        return products;
    }
}
