package ru.asd.CRUDSpring.DAO;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAOImpl implements UserDAO, UserDetailsService {
    @PersistenceContext
    private EntityManager eMrF;

    @Override
    public void addUser(ru.asd.CRUDSpring.entity.User user) {
        eMrF.persist(user);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Getting access details from employee dao !!");

        // Ideally it should be fetched from database and populated instance of
        // #org.springframework.security.core.userdetails.User should be returned from this method
        //    UserDetails user = new User(login, "password", true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
        //      return user;
        return null;
    }


}
