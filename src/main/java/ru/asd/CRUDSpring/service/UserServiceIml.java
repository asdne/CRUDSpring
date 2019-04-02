package ru.asd.CRUDSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asd.CRUDSpring.DAO.UserDAO;
import ru.asd.CRUDSpring.entity.User;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(String login) {
        return new User("asd","password");
    }


}
