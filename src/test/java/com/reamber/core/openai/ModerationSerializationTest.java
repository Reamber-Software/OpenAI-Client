package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reamber.core.openai.model.request.moderation.ModerationModel;
import com.reamber.core.openai.model.request.moderation.ModerationRequest;
import com.reamber.core.openai.model.response.moderation.Moderation;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModerationSerializationTest extends BaseTest {

    @Test
    void testSerialize() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/moderation.json");

        final var request = ModerationRequest.builder()
                .model(ModerationModel.LATEST)
                .input("This is a test")
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/moderation.json");

        final var om = new ObjectMapper();

        final var result = om.readValue(content, Moderation.class);

        assertEquals(1, result.getResults().size());
        assertEquals(0.5707283616065979, result.getResults().get(0).getCategoryScores().getHate());
    }
}