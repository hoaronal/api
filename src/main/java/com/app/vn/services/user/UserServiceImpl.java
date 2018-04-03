package com.app.vn.services.user;

import java.util.Arrays;

import com.app.vn.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.vn.common.model.User;
import com.app.vn.repository.user.UserRepositoryCustom;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        short enabled = 1;
        User activeUserInfo = userRepository.getUserByUserNameAndEnabled(userName,enabled);


        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
        UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUserInfo.getUserName(), activeUserInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
