package ru.asd.CRUDSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.asd.CRUDSpring.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user1= userService.getUser("fsd");
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails= new org.springframework.security.core.userdetails.User(user1.getLogin(),user1.getPassword(),roles);
        return userDetails;
    }
}
