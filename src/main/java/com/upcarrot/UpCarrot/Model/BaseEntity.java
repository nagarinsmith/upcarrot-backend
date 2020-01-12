package com.upcarrot.UpCarrot.Model;


import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class BaseEntity {
    @Id
    private String id;

    public BaseEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}