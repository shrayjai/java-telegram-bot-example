package com.shrayjai.bot.service;

import com.shrayjai.bot.Bot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSender extends Bot {

    public void sendText(Long userId, String message) {
        SendMessage sendMessage = SendMessage.builder().chatId(userId.toString()).text(message).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
