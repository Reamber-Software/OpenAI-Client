package com.reamber.core.openai.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.model.response.completion.Logprob;
import lombok.Data;

@Data
public class Choice {

    private String text;

    private long index;

    private Logprob logprobs;

    @JsonProperty("finish_reason")
    private String finishReason;
}