package com.app.vn.repository.user;

import com.app.vn.common.model.User;

public interface UserRepositoryCustom {

    User getActiveUser(String userName);
}
