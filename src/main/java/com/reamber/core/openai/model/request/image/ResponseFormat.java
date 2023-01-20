package com.reamber.core.openai.model.request.image;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ResponseFormat {

    URL("url"),

    B64_JSON("b64_json");

    private final String format;

    @JsonValue
    public String getFormat() {
        return format;
    }
}
