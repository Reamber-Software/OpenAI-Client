package com.reamber.core.openai.model;

import lombok.Data;

@Data
public class BaseError {

    private String code;

    private String message;

    private String param;

    private String type;
}