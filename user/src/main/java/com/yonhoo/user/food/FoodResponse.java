package com.yonhoo.user.food;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FoodResponse {
    private String foodName;
    private Integer foodId;
    private SubFood subFood;
    private LocalDate date;
    private boolean status;


    @Getter
    @Setter
    public static class SubFood {
        private List<String> templateList;
        private Map<String, String> productNoToCourse;
    }
}
