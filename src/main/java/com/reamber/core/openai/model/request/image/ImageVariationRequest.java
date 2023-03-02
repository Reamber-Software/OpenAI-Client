package com.reamber.core.openai.model.request.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.File;

/**
 * @see <a href="https://platform.openai.com/docs/api-reference/images/create-variation">OpenAI Image Variation API</a>
 */
@Data
@Builder
public class ImageVariationRequest {

    /**
     * The image to use as the basis for the variation(s). Must be a valid PNG file, less than 4MB, and square.
     */
    private File image;

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    @JsonProperty("n")
    private int n;

    /**
     * The size of the generated images. Must be one of {@link ImageSize#X_256}, {@link ImageSize#X_512}, {@link ImageSize#X_1024}.
     */
    @JsonProperty("size")
    private ImageSize size;

    /**
     * The format in which the generated images are returned. Must be one of {@link ResponseFormat#URL} or {@link ResponseFormat#B64_JSON}.
     */
    @JsonProperty("response_Format")
    private ResponseFormat responseFormat;

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    @JsonProperty("user")
    private String user;
}