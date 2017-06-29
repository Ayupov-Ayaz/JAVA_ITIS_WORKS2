package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.itis.Service.UsersService;
import ru.itis.Service.impl.UsersServiceImpl;
import ru.itis.models.UserDataForRegistrationDto;
import ru.itis.models.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        template.setMessageConverters(converters);

        Scanner scanner = new Scanner(System.in);
        String token;
        System.out.println("Добро пожаловать в чат. Выберите дальнейшие действия:" +
                "1. Регистрация" +
                "2. Авторизация");
        while(true){
            int i = scanner.nextInt();
            if(i == 1){
                token = registration(template);
                break;
            }else{
                token = login();
                break;
            }
        }
        headers.add("Auth-Token", token);




    }
    private static String login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        UsersService usersService = new UsersServiceImpl();
        return usersService.login(login,password);
    }
    private static String registration(RestTemplate template){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите login: \n");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: \n");
        String password = scanner.nextLine();
        System.out.println("Введите ваше имя: \n");
        String name = scanner.nextLine();
        System.out.println("Введите возраст: \n");
        int age = scanner.nextInt();
        UsersService usersService = new UsersServiceImpl();
        return usersService.registration(login,password,name,age);
    }

    private static void startChat(MultiValueMap<String, String> headers, RestTemplate template){
        Runnable sendMessageTask = () -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String messageText = scanner.next();
                MessageDto message = new MessageDto();
                message.setMessage(messageText);
                HttpEntity<MessageDto> request = new HttpEntity<>(message, headers);
                template.postForEntity("http://localhost:8080/messages", request, Void.class );
            }
        };

        Runnable getMessagesTask = () -> {
            while (true) {
                HttpEntity entity = new HttpEntity(headers);
                System.out.println("get messages");
                ResponseEntity<MessagesDto> response = template.exchange(
                        "http://localhost:8080/messages", HttpMethod.GET, entity, MessagesDto.class);
                if (response.getBody().getMessages().size() != 0) {
                    System.out.println(response.getBody().getMessages());
                }
            }
        };

        Thread sendMessages = new Thread(sendMessageTask);
        Thread getMessages = new Thread(getMessagesTask);
        sendMessages.start();
        getMessages.start();
    }
}
