package com.playonfantasy.playonfantasyapi.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DraftController {

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public String receiveMessage(@Payload String message){
        return message;
    }
}
