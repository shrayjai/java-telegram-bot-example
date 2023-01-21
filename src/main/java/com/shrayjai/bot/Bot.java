package com.shrayjai.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "ENV_BOT_USERNAME";
    }

    @Override
    public String getBotToken() {
        return "ENV_BOT_TOKEN";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long userId = update.getMessage().getFrom().getId();
        String message = update.getMessage().getText();

        System.out.println(userId + ":" + message);

        sendText(userId, "Ack -> " + message);
    }

    private void sendText(Long userId, String message) {
        SendMessage sendMessage = SendMessage.builder().chatId(userId.toString()).text(message).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
