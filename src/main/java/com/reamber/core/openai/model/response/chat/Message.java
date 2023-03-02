package com.reamber.core.openai.model.response.chat;

import com.reamber.core.openai.model.request.chat.ChatRole;
import lombok.Data;

@Data
public class Message {

    private ChatRole role;

    private String content;
}