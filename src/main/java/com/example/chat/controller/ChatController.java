package com.example.chat.controller;

import com.example.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.time.LocalTime;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // client gửi đến /app/sendMessage
    @SendTo("/topic/messages")      // gửi tin nhắn tới tất cả client subscribe /topic/messages
    public ChatMessage send(ChatMessage message) {
        message.setTime(LocalTime.now().toString());
        return message;
    }
}
