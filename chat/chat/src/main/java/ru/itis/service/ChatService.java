package ru.itis.service;

import ru.itis.dto.MessageDto;

import java.util.List;


public interface ChatService {
    /**
     * получить все сообщения в чате
     * @param token -токен аутентификации пользователя
     * @param chatId -идентификатор чата
     * @return лист сообщений
     */
    List<MessageDto> getMessages(String token, int chatId);

    /**
     * Сохранить сообщение от автора с token-ом, и разослать всем в чате
     * @param token -токен аутентификации пользователя
     * @param chatId -идентификатор чата
     * @param message -сообщение
     */
    void saveAndDeliverMessage(String token, int chatId, MessageDto message);

    /**
     * Проверяет, состоит ли пользователь в чате
     * @param token токен пользователя
     * @param chatId идентификатор чата
     * @return  истина или ложь
     */
    boolean isUserInChat(String token, int chatId);
}
