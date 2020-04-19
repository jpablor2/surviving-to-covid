package com.example.survivingtocovid.model;

import java.util.List;
import java.util.UUID;

public class CookingAdvices extends Advice {

    private String recipeTitle;
    private List<String> ingredients;

    public CookingAdvices(UUID id, List<String> instructions, String onlineAcademyUrl, String category, String activityName, String recipeTitle, List<String> ingredients) {
        super(id, instructions, onlineAcademyUrl, category, activityName);
        this.recipeTitle = recipeTitle;
        this.ingredients = ingredients;
    }
}
