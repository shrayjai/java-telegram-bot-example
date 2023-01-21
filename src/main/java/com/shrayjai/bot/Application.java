package com.shrayjai.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        try {
            new TelegramBotsApi(DefaultBotSession.class).registerBot(new Bot());
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
