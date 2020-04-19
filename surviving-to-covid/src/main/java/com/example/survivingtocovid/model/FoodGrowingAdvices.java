package com.example.survivingtocovid.model;

import java.util.List;
import java.util.UUID;

public class FoodGrowingAdvices extends Advice {

    private String productName;
    private int minimumFieldMetersSize;

    public FoodGrowingAdvices(UUID id, List<String> instructions, String onlineAcademyUrl, String category, String activityName, String productName, int minimumFieldMetersSize) {
        super(id, instructions, onlineAcademyUrl, category, activityName);
        this.productName = productName;
        this.minimumFieldMetersSize = minimumFieldMetersSize;
    }
}
