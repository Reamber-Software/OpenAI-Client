package com.reamber.core.openai.model.response.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * <a href="https://platform.openai.com/docs/api-reference/images">Images</a>
 */
@Data
public class Image {

    @JsonProperty("url")
    private String url;

    @JsonProperty("b64_json")
    private String b64Json;
}