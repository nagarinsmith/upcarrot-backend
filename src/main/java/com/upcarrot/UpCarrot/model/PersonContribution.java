package com.upcarrot.UpCarrot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("personContribution")
public class PersonContribution {
    @Id
    private String id;
    private Float contributionPercentage;
    private Person person;

    public PersonContribution(String id, Float contributionPercentage, Person person){
        this.id = id;
        this.contributionPercentage = contributionPercentage;
        this.person = person;
    }
    public String getId() {
        return id;
    }

    public Float getContributionPercentage() {
        return contributionPercentage;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContributionPercentage(Float contributionPercentage) {
        this.contributionPercentage = contributionPercentage;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
