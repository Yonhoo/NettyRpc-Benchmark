package com.yonhoo.server.student;

import com.yonhoo.user.student.Book;
import com.yonhoo.user.student.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentImpl implements Student {
    @Override
    public List<Book> getBook() {
        List<Book> userList = new ArrayList<>(15);

        for (int i = 0; i < 15; i++) {
            Book user = new Book();

            user.setId(i);
            user.setName("Doug Lea" + i);
            user.setSex(1);
            user.setBirthday(LocalDate.of(1968, 12, 8));
            user.setEmail("dong.lea@gmail.com" + i);
            user.setMobile("18612345678" + i);
            user.setAddress("北京市 中关村 中关村大街1号 鼎好大厦 1605" + i);
            user.setIcon("https://www.baidu.com/img/bd_logo1.png" + i);
            user.setStatus(1);
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(user.getCreateTime());

            List<Integer> permissions = new ArrayList<Integer>(
                    Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 19, 88, 86, 89, 90, 91, 92));
            user.setPermissions(permissions);

            userList.add(user);
        }

        return userList;
    }
}
