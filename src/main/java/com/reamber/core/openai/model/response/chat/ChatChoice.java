package com.reamber.core.openai.model.response.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChatChoice {

    private Message message;

    private long index;

    @JsonProperty("finish_reason")
    private String finishReason;
}