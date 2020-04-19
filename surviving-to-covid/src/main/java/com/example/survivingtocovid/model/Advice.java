package com.example.survivingtocovid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "Advice")
public class Advice {
    private List<String> instructions;
    private String onlineAcademyUrl;
    private String category;
    private String activityName;
    @Id
    private UUID id;


    public Advice(
            @JsonProperty("id") UUID id,
            @JsonProperty("instructions") List<String> instructions,
            @JsonProperty("onlineAcademyUrl") String onlineAcademyUrl,
            @JsonProperty("category") String category,
            @JsonProperty("activityName") String activityName) {
        this.instructions = instructions;
        this.onlineAcademyUrl = onlineAcademyUrl;
        this.category = category;
        this.activityName = activityName;
        this.id = id;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public String getOnlineAcademyUrl() {
        return onlineAcademyUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getActivityName() {
        return activityName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public void setOnlineAcademyUrl(String onlineAcademyUrl) {
        this.onlineAcademyUrl = onlineAcademyUrl;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
