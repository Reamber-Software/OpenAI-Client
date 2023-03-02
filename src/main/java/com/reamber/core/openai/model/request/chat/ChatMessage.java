package com.reamber.core.openai.model.request.chat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatMessage {

    private final ChatRole role;

    private final String content;
}
