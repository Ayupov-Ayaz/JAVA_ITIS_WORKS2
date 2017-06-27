package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.models.enums.UserRoleEnum;
import ru.itis.services.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * 27.06.2017
 * UserDetailsServiceImpl
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        //получаем User'a
        User user = userService.getUserByLogin(login);
        //указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

        // На основании полученных данных формируем объект UserDetails
        // Который позволит проверить введенный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),user.getHashPassword(),roles);
        return userDetails;
    }
}
