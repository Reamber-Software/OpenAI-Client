package com.reamber.core.openai;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract class BaseTest {

    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    public String trim(String text) {
        return text.replaceAll("\\s+", "");
    }
}