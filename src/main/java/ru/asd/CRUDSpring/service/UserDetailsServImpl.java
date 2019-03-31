package ru.asd.CRUDSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.asd.CRUDSpring.entity.User;
import ru.asd.CRUDSpring.entity.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user= userService.getUser("fsd");
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
        UserDetails userDetails= new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),roles);
        return userDetails;
    }
}
