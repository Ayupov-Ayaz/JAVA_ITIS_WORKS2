package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.MessageDto;
import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.model.User;
import ru.itis.service.ChatService;
import ru.itis.service.UsersService;

import java.util.List;

/**
 * 11.07.2017
 * UsersController
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ChatService chatService;

    /**
     * Регистрация пользователя
     * @param user - данные для регистрации
     * @return базовая информация о пользователе
     */
    @PostMapping("/users")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDataForRegistrationDto user){
        return new ResponseEntity<>(usersService.registerUser(user), HttpStatus.OK);
    }

    /**
     * Получение всех пользователей
     * @return список пользователей в бд
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.ACCEPTED);
    }

    /**
     * Авторизация пользователя
     * @param password - пароль введенный пользователем в форме
     * @param login - логин введенный пользователем в форме
     * @return данные для аутентификации пользователя, то есть token
     */
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader("password") String password,
                                         @RequestHeader("login") String login){
        String token = usersService.login(password,login);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token",token);
        return new ResponseEntity<Object>(null, headers, HttpStatus.OK);
    }

    /**
     * Отправка сообщений в чате
     * @param message -сообщение
     * @param chatId -идентификатор чата
     * @param token -токен пользователя, для аутентификации
     * @return данные о результатах операции, то есть статус
     */
    @PostMapping("/chats/{chat-id}/messages")
    public ResponseEntity<Object> postMessage(@RequestBody MessageDto message,
                                                        @PathVariable("chat-id") int chatId,
                                                        @RequestHeader("Auth-Token") String token){
        chatService.saveAndDeliverMessage(token,chatId,message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * Получить все сообщения чата
     * @param chatId - идентификатор чата
     * @param token - данные аутентификации пользователя
     * @return - список сообщений
     */
    @GetMapping("chats/{chat-id}/messages")
    public ResponseEntity<List<MessageDto>> getMessages( @PathVariable("chat-id") int chatId,
                                                         @RequestHeader("Auth-Token") String token){
        return new ResponseEntity<>(chatService.getMessages(token,chatId), HttpStatus.ACCEPTED);
    }
}
