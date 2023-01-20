package com.reamber.core.openai.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Usage {

    @JsonProperty("completion_tokens")
    private long completionTokens;

    @JsonProperty("prompt_tokens")
    private long promptTokens;

    @JsonProperty("total_tokens")
    private long totalTokens;
}