package com.app.vn.service.user;

import com.app.vn.common.model.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User add(User user);

    public User getByLoginId(String loginId);

    public User getByEmail(String email);

    public Page<User> getUsers(int pageNumber, int pageSize);
}
