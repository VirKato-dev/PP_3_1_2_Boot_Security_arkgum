package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.repository.CrudRepository;
import ru.kata.spring.boot_security.demo.model.Role;

public interface RoleDao extends CrudRepository<Role,Long> {
    Role findRoleByAuthority(String a);
}
