package ru.asd.CRUDSpring.service;

import org.springframework.stereotype.Service;
import ru.asd.CRUDSpring.entity.User;

@Service
public class UserServiceIml implements UserService{
    @Override
    public User getUser(String login) {
        return new User("asd","password");
    }
}
