package com.reamber.core.openai.model.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseResponse {

    @JsonProperty("allow_search_indices")
    private boolean allowSearchIndices;

    private long created;

    private String organization;

    @JsonProperty("allow_sampling")
    private boolean allowSampling;

    @JsonProperty("allow_create_engine")
    private boolean allowCreateEngine;

    @JsonProperty("allow_logprobs")
    private boolean allowLogprobs;

    @JsonProperty("is_blocking")
    private boolean isBlocking;

    @JsonProperty("allow_view")
    private boolean allowView;

    @JsonProperty("allow_fine_tuning")
    private boolean allowFineTuning;

    private String group;
}