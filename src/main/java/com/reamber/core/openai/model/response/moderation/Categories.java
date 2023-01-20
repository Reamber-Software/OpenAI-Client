package com.reamber.core.openai.model.response.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Categories {

    @JsonProperty("hate/threatening")
    private boolean hateThreatening;

    @JsonProperty("sexual/minors")
    private boolean sexualMinors;

    private boolean hate;

    @JsonProperty("self-harm")
    private boolean selfHarm;

    private boolean sexual;

    @JsonProperty("violence/graphic")
    private boolean violenceGraphic;

    private boolean violence;
}