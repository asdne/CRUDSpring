package ru.asd.CRUDSpring.DAO;

import ru.asd.CRUDSpring.entity.UserRole;

public interface UserRoleDAO {
    UserRole getRolebyId(Long id);

    UserRole getRoleByName(String roleName);

    UserRole createRoleIfNotFound(final String name);
}
