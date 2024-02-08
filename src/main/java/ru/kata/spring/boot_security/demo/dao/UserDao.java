package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    User get(long id);
    List<User> getAll();
    void update(long id,User user);
    void delete(long id);
    void delete(User user);
    List<User> find(User user);



}
