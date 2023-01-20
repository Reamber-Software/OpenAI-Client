package com.reamber.core.openai.model.request.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @see <a href="https://beta.openai.com/docs/api-reference/images/create">OpenAI Image Create API</a>
 */
@Data
@Builder
public class ImageGenerationRequest {

	/**
	 * A text description of the desired image(s). The maximum length is 1000 characters.
	 */
    private String prompt;

	/**
	 * The number of images to generate. Must be between 1 and 10.
	 */
    private int n;

	/**
	 * The size of the generated images. Must be one of {@link ImageSize#X_256}, {@link ImageSize#X_512}, {@link ImageSize#X_1024}.
	 */
    private ImageSize size;

	/**
	 * The format in which the generated images are returned. Must be one of {@link ResponseFormat#URL} or {@link ResponseFormat#B64_JSON}.
	 */
    @JsonProperty("response_format")
    private ResponseFormat responseFormat;

	/**
	 * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
	 */
    private String user;
}