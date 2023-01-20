package com.reamber.core.openai.model.request.image;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ImageSize {

    X_256("256x256"),

    X_512("512x512"),

    X_1024("1024x1024");

    private final String size;

    @JsonValue
    public String getSize() {
        return size;
    }
}
