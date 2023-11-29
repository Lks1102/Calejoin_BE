package kr.co.calejoin.controller;

import kr.co.calejoin.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public void enter(ChatMessage message) {
        log.info("enter...1");

        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            log.info("enter...2");
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }

        log.info("enter...3");
        sendingOperations.convertAndSend("/topic/messages", message);
    }
}