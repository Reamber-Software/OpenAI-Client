package com.reamber.core.openai.model.request.image;

import feign.form.FormProperty;
import lombok.Builder;
import lombok.Data;

import java.io.File;

/**
 * @see <a href="https://platform.openai.com/docs/api-reference/images/create-edit">OpenAI Image Edit API</a>
 */
@Data
@Builder
public class ImageEditRequest {

    /**
     * The image to edit. Must be a valid PNG file, less than 4MB, and square. If mask is not provided, image must have transparency, which will be used as the mask.
     */
    private File image;

    /**
     * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate where {@link ImageEditRequest#image} should be edited. Must be a valid PNG file, less than 4MB, and have the same dimensions as {@link ImageEditRequest#image}.
     */
    private File mask;

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters.
     */
    @FormProperty("prompt")
    private String prompt;

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    @FormProperty("n")
    private int n;

    /**
     * The size of the generated images. Must be one of {@link ImageSize#X_256}, {@link ImageSize#X_512}, {@link ImageSize#X_1024}.
     */
    @FormProperty("size")
    private ImageSize size;

    /**
     * The format in which the generated images are returned. Must be one of {@link ResponseFormat#URL} or {@link ResponseFormat#B64_JSON}.
     */
    @FormProperty("response_Format")
    private ResponseFormat responseFormat;

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    @FormProperty("user")
    private String user;
}