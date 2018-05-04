package ru.zhukov.tradeunion.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("111");
        UserDetails user =
                    User.withUsername("user")
                        .password("$2a$10$vdFFrZOV3y3ul9VXuk9P6OfiVcOkspUzM0pz/.G69M6IwsDmL//u6")
                        .roles("USER")
                        .build();
        return user;
    }
}
