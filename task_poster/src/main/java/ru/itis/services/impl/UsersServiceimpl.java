package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dao.RolesDao;
import ru.itis.dao.UsersDao;
import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.security.utils.TokenGenerator;
import ru.itis.services.UsersService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.itis.converter.Converter.convert;

/**
 * 26.06.2017
 * Implementation of {@link UsersService} interface
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class UsersServiceimpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private RolesDao rolesDao;

    @Autowired
    private TokenGenerator generator;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();



    @Override
    public UserDto registerUser(UserDataForRegistrationDto user) {
        // конвертируем дто в модель и кодируем пароль
        Set<Role> roles = new HashSet<>();
        roles.add(rolesDao.getOne(1));

        User newUser = convert(user,
                dto-> new User.Builder()
                .login(dto.getLogin())
                .hashPassword(encoder.encode(dto.getPassword()))
                .age(dto.getAge())
                .name(dto.getName())
                .roles(roles)
                .build()
                );
        // сохраняем пользователя и получаем его уже с id
        User savedUser = usersDao.save(newUser);

        return convert(savedUser,
                model -> new UserDto(model.getId(),model.getAge(),model.getLogin(),model.getName()));
    }

    @Override
    @Transactional
    public String login(String password, String login) {
        User registreitedUser = usersDao.findByLogin(login);

        if(encoder.matches(password, registreitedUser.getHashPassword())){
            // генерируем уникальный токен
            String token = generator.generateToken();
            // обновляем токен пользователя
            usersDao.updateToke(registreitedUser.getId(), token);

            return token;
        }else throw new IllegalArgumentException("Incorrect username or password.");
    }

    @Override
    public List<User> getUsers() {
        return usersDao.findAll();
    }

    @Override
    public UserDto findByName(String name) {
        User user = usersDao.findByName(name);
        return convert(user, model -> new UserDto(
                model.getId(), model.getAge(), model.getName(), model.getLogin()));
    }
}
