package com.reamber.core.openai.model.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <a href="https://beta.openai.com/docs/api-reference/models">Model</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ModelDetails extends BaseResponse {

    private String parent;

    private String root;

    @JsonProperty("owned_by")
    private String ownedBy;

    private List<Permission> permission;

    private boolean deleted;
}