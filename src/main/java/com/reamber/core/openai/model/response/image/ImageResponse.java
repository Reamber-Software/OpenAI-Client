package com.reamber.core.openai.model.response.image;

import lombok.Data;

import java.util.List;

/**
 * <a href="https://beta.openai.com/docs/api-reference/images">Images</a>
 */
@Data
public class ImageResponse {

    private int created;

    private List<Image> data;

}