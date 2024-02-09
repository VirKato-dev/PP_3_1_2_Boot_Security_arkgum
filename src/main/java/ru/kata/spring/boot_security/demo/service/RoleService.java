package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

@Service
public class RoleService {
    private final RoleDao roleDao;
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    public Role createRole(String role){
        role = "ROLE_" + role;
        Role r = roleDao.findRoleByAuthority(role);
        if(r == null){
           return roleDao.save(new Role(role));
        }
        return r;
    }
}
