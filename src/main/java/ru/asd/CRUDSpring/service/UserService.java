package ru.asd.CRUDSpring.service;

import org.springframework.stereotype.Service;
import ru.asd.CRUDSpring.entity.User;

@Service
public interface UserService {
    User getUser(String login);
}
