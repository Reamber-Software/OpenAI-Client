package com.reamber.core.openai.model.response.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryScores {

    @JsonProperty("hate/threatening")
    private Object hateThreatening;

    @JsonProperty("sexual/minors")
    private Object sexualMinors;

    private Object hate;

    @JsonProperty("self-harm")
    private Object selfHarm;

    private Object sexual;

    @JsonProperty("violence/graphic")
    private Object violenceGraphic;

    @JsonProperty("violence")
    private Object violence;
}