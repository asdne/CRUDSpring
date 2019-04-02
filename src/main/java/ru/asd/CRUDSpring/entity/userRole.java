package ru.asd.CRUDSpring.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "javalearning")
public class userRole {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String role;

    @ManyToMany (fetch = FetchType.EAGER,mappedBy = "roles",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public userRole() {
    }
}
