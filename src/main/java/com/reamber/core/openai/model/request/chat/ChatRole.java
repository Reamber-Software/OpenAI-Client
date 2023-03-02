package com.reamber.core.openai.model.request.chat;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * <a href="https://platform.openai.com/docs/guides/chat/introduction">Chat Roles</a>
 */
@RequiredArgsConstructor
public enum ChatRole {

    SYSTEM("system"),
    ASSISTANT("assistant"),
    USER("user");

    private final String role;

    @JsonValue
    public String getRole() {
        return role;
    }
}
