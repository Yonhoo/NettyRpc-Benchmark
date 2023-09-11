package com.yonhoo.user.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class UserResponse {
    private String userName;
    private Integer userId;
    private SubUser subUser;
    private LocalDate date;
    private boolean status;


    @Getter
    @Setter
    public static class SubUser {
        private List<String> templateList;
        private Map<String, String> productNoToCourse;
    }
}
