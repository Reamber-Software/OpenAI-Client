package com.reamber.core.openai.model.request.moderation;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ModerationModel {

    STABLE("text-moderation-stable"),

    LATEST("text-moderation-latest");

    private final String model;

    @JsonValue
    public String getModel() {
        return model;
    }
}
