package com.app.vn.service.user;

import com.app.vn.common.model.User;
import com.app.vn.common.utils.PasswordUtil;
import com.app.vn.repository.user.UserRepository;
import com.app.vn.repository.user.UserRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl extends SavedRequestAwareAuthenticationSuccessHandler implements UserService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User activeUserInfo = userRepository.findOneByLoginId(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
        UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUserInfo.getLoginId(), activeUserInfo.getLoginPassword(), Arrays.asList(authority));
        return userDetails;
    }

    @Override
    @Transactional(readOnly=false)
    public User add(User user) {
        try {
            user.setLoginPassword(PasswordUtil.genarate(user.getLoginPassword()));
            return userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByLoginId(String loginId) {
        User user = userRepositoryCustom.getActiveUser(loginId);
        return userRepository.findOneByLoginId(loginId);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Page<User> getUsers(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Specification<User> specification = new Specification<User>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                return cb.and(predicates.toArray(new Predicate[0]));
            }

        };
        return userRepository.findAll(specification, pageRequest);
    }
}
