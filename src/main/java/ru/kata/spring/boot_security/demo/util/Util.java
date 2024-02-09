package ru.kata.spring.boot_security.demo.util;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Util {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public Util(UserService userService, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addUsers() {
        Role admin = roleService.createRole("ADMIN");
        Role user = roleService.createRole("USER");
        userService.create(new User("Arkadiy", "Gumelya","arkgum@gmail.com","arkgum", passwordEncoder.encode("admin"),  List.of(admin,user)));
        userService.create(new User("Konstantin", "Golubev","kostya@gmail.com","kongol", passwordEncoder.encode("kon"),List.of(user)));
        userService.create(new User("Svetlana", "Mineeva","sveta@gmail.com","svemin", passwordEncoder.encode("sve") ,List.of(user)));
        userService.create(new User("Daniyal", "Shahnazarov","danya@gmail.com","dansha", passwordEncoder.encode("dan"),List.of(user)));
    }
}
