package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reamber.core.openai.model.request.image.ImageGenerationRequest;
import com.reamber.core.openai.model.request.image.ImageSize;
import com.reamber.core.openai.model.request.image.ResponseFormat;
import com.reamber.core.openai.model.response.image.ImageResponse;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ImageSerializationTest extends BaseTest {

    @Test
    void testSerializeImageGeneration() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/image_generation.json");

        final var request = ImageGenerationRequest.builder()
                .prompt("A test image")
                .n(1)
                .size(ImageSize.X_1024)
                .responseFormat(ResponseFormat.URL)
                .user("OpenAI User")
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize_url() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/image_url.json");

        final var om = new ObjectMapper();

        final var result = om.readValue(content, ImageResponse.class);

        final var image = result.getData().get(0);

        assertNull(image.getB64Json());
        assertEquals("https://example.com/image", image.getUrl());
    }

    @Test
    void testDeserialize_json() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/image_b64.json");

        final var om = new ObjectMapper();

        final var result = om.readValue(content, ImageResponse.class);

        final var image = result.getData().get(0);

        assertNull(image.getUrl());
        assertEquals("iVBORw0KGgo", image.getB64Json());
    }

}