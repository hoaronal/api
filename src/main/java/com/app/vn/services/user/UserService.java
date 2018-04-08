package com.app.vn.services.user;

import com.app.vn.common.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public void add(User user);

    public User getByLoginId(String loginId);
}
