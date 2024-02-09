package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;


@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void create(User user) {
        userDao.save(user);
    }


    @Transactional(readOnly = true)
    public User get(long id) {
        return userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }


    @Transactional(readOnly = true)
    public Collection<User> getAll() {
        return (Collection<User>) userDao.findAll();
    }


    public void update(long id, User user) {
        User u = get(id);
        if(u!=null){
            user.setId(id);
        }
        userDao.save( user);
    }


    public void delete(long id) {
        userDao.deleteById(id);
    }


    public void delete(User user) {
        userDao.delete(user);
    }


    @Transactional(readOnly = true)
    public User find(User user) {
        return get(user.getId());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("No Username");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getRoleList());
    }
}
