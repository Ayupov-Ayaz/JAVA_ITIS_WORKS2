package ru.itis.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.itis.service.ChatService;
import ru.itis.service.SessionsService;

import java.io.IOException;

/**
 * 11.07.2017
 * AuthHandler
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
// перехватчик сообщений из определенной сессии сокета
public class AuthHandler {
    @Autowired
    private SessionsService sessionsService;

    @Autowired
    private ChatService chatService;

    /**
     * Перехват текстового сообщения
     * @param session -текущая сессия
     * @param textMessage - данные сообщения содержащая в себе токен, идентификатор сообщения, сообщение
     * @throws IOException
     */
    public void handlerTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        System.out.println(textMessage.getPayload());
        // вытаскиваем сообщения и делим его по пробелам
        String[] message = textMessage.getPayload().split(" ");
        //вытаскиваем токен
        String token = message[0];
        // вытаскиваем идентификатор чата
        int chatId = Integer.parseInt(message[1]);

        if(!chatService.isUserInChat(token,chatId)){
            // закрываем сессию, если наш пользователь не подписан к чату
            session.close();
        }else{
            // подтверждаем сессию
            sessionsService.submitSession(chatId,session);
        }
    }
}
