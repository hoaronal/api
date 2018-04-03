package com.app.vn.repository.user;

import com.app.vn.common.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User getUserByUserNameAndEnabled(String username, short enabled);
}
