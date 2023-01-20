package com.reamber.core.openai.model.response.completion;

import lombok.Data;

@Data
public class LogprobEntry {

    private final String key;

    private final Double value;
}