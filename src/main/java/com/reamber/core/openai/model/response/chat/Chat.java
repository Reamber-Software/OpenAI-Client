package com.reamber.core.openai.model.response.chat;

import com.reamber.core.openai.model.BaseResponse;
import com.reamber.core.openai.model.response.Usage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <a href="https://platform.openai.com/docs/api-reference/chat">Chat</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Chat extends BaseResponse {

    private String model;

    private Usage usage;

    private List<ChatChoice> choices;
}
