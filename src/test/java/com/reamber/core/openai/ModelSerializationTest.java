package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reamber.core.openai.model.response.ListResponse;
import com.reamber.core.openai.model.response.model.ModelDetails;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelSerializationTest {

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/models.json");

        final var om = new ObjectMapper();

        final var result = om.readValue(content, new TypeReference<ListResponse<ModelDetails>>() {
        });

        assertEquals("list", result.getObject());
        assertEquals(66, result.getData().size());
    }

}