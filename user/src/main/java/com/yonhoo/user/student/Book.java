package com.yonhoo.user.student;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Book {
    private static final long serialVersionUID = 2566816725396650300L;

    private long id;
    private String name;
    private int sex;
    private LocalDate birthday;
    private String email;
    private String mobile;
    private String address;
    private String icon;
    private List<Integer> permissions;
    private int status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
