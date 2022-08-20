package ru.kata.spring.boot_security.demo.utils;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperUser {

    public UserDTO toUserDTO (User user) {
        Set<String> roleDTO = user.getRoles().stream().map(r -> r.getRole()).collect(Collectors.toSet());
        UserDTO toDTO = new UserDTO (
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getEmail(),
                user.getPassword(),
                roleDTO
        );
        return toDTO;
    }

}
