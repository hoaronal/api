package com.app.vn.repository.user;

import com.app.vn.common.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getActiveUser(String loginId) {
        User activeUserInfo = new User();
        short enabled = 1;
        List<?> list = entityManager.createQuery("SELECT u FROM User u WHERE loginId = :loginId")
                .setParameter("loginId", loginId).getResultList();
        if(!list.isEmpty()) {
            activeUserInfo = (User)list.get(0);
        }
        return activeUserInfo;
    }
}
