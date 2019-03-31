package ru.asd.CRUDSpring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "roles", schema = "javalearning", catalog = "")
public enum UserRoleEnum {
    ADMIN,
    USER,
    ANONYMOUS;

    UserRoleEnum() {
    }

}
