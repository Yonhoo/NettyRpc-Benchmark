package com.yonhoo.server.user;

import com.yonhoo.user.request.User;
import com.yonhoo.user.request.UserResponse;

import java.time.LocalDate;
import java.util.*;

public class UserImpl implements User {

    @Override
    public String getUserName(String userAlias) {
        return userAlias;
    }

    @Override
    public List<UserResponse> getUserResponse() {
        List<UserResponse> userResponses = new ArrayList<>(10);
        List<String> templateList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            templateList.add(UUID.randomUUID().toString());
        }
        Map<String, String> p2C = new HashMap<>(10);
        for (int i = 0; i < 10; i++) {
            p2C.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }

        for (int i = 0; i < 10; i++) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserName("UserName");
            userResponse.setUserId(100000);
            userResponse.setDate(LocalDate.now());
            userResponse.setStatus(true);
            UserResponse.SubUser subUser = new UserResponse.SubUser();
            subUser.setTemplateList(templateList);
            subUser.setProductNoToCourse(p2C);
            userResponse.setSubUser(subUser);
            userResponse.setSubUser(subUser);
            userResponses.add(userResponse);
        }

        return userResponses;
    }
}
