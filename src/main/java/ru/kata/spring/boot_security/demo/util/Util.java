package ru.kata.spring.boot_security.demo.util;


import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class Util {

    private final UserService userService;

    public Util(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void addUsers() {
        userService.create(new User("Arkadiy", "Gumelya","arkgum@gmail.com"));
        userService.create(new User("Konstantin", "Golubev","kostya@gmail.com"));
        userService.create(new User("Svetlana", "Mineeva","sveta@gmail.com"));
        userService.create(new User("Daniyal", "Shahnazarov","danya@gmail.com"));
    }
}
