package com.example.aimlchatbot.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Model representing a chat message.
 *
 * @author yann39
 * @since 0.0.1
 */
@Getter
@Setter
public class ChatMessage {

    private String from;
    private String message;
    private LocalDateTime sentOn;

}
