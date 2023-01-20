package com.reamber.core.openai.model.response.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModerationEntry {

    private Categories categories;

    @JsonProperty("category_scores")
    private CategoryScores categoryScores;

    private boolean flagged;

}