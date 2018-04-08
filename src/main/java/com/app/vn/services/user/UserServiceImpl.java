package com.app.vn.services.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import com.app.vn.repository.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.app.vn.common.model.User;
import com.app.vn.repository.user.UserRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

        /*if (!StringUtils.hasText(userName)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        User user;
        if (!userName.contains("@")) {
            user = userRepository.findOneByLoginId(userName);
        } else {
            user = userRepository.findOneByEmail(userName);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User ID not existing. [" + userName + "]");
        }

        return new AuthorizedUser(user);*/
    }

    /*@Transactional(readOnly=false)
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        AuthorizedUser authorizedUser = (AuthorizedUser) authentication.getPrincipal();
        userRepository.updateLastLoginTime(authorizedUser.getId(), new Date());
        logger.info("\"{}\" logged in. IP: [{}]", authorizedUser.toString(), request.getRemoteAddr());
        super.onAuthenticationSuccess(request, response, authentication);
    }*/

    @Override
    @Transactional(readOnly=false)
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByLoginId(String loginId) {
        return userRepository.findOneByLoginId(loginId);
    }
}
