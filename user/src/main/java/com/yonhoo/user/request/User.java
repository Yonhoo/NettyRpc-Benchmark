package com.yonhoo.user.request;

import java.util.List;

public interface User {
    String getUserName(String userAlias);

    List<UserResponse> getUserResponse();
}
