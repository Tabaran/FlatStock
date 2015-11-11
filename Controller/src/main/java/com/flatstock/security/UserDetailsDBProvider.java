package com.flatstock.security;

import com.flatstock.dao.UserDao;
import com.flatstock.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtabaran on 11/11/2015.
 */
@Service
@Transactional(readOnly=true)
public class UserDetailsDBProvider implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;


        //com.flatstock.model.User domainUser = //userDao.getUserByLogin(login);
        return new User(/*domainUser.getLogin()*/"admin",
                /*domainUser.getPassword()*/"pass",
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getRoles(/*domainUser.getRole()*/Role.ADMINISTRATOR));
    }

    public List<SimpleGrantedAuthority> getRoles(Role role){
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(/*role.toString()*/"ADMIN"));
        return roles;
    }

}
