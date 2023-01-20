package com.reamber.core.openai.model.response.completion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.reamber.core.openai.jackson.TopLogProbsDeserializer;
import lombok.Data;

import java.util.List;

@Data
public class Logprob {

    private List<String> tokens;

    @JsonProperty("token_logprobs")
    private List<Double> tokenLogprobs;

    @JsonProperty("top_logprobs")
    @JsonDeserialize(using = TopLogProbsDeserializer.class)
    private List<LogprobEntry> topLogprobs;

    @JsonProperty("text_offset")
    private List<Integer> textOffset;
}