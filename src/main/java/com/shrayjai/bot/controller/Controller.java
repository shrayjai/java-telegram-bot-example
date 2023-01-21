package com.shrayjai.bot.controller;

import com.shrayjai.bot.service.MessageSender;
import com.shrayjai.bot.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private MessageSender messageSender;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody Message message) {
        messageSender.sendText(message.getUserId(), message.getMessage());
        return ResponseEntity.noContent().build();
    }
}
