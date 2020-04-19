package com.example.survivingtocovid.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Advice {
    private List<String> instructions;
    private String onlineAcademyUrl;
    private String category;
    private String activityName;
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

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public String getOnlineAcademyUrl() {
        return onlineAcademyUrl;
    }

    public void setOnlineAcademyUrl(String onlineAcademyUrl) {
        this.onlineAcademyUrl = onlineAcademyUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
