package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "role")
    String authority;


    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String role) {
        this.authority = role;
    }

    @Override
    public String getAuthority() {
        return authority;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + authority + '\'' +
                '}';
    }


}
