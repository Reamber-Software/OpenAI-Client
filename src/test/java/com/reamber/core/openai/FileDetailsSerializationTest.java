package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reamber.core.openai.model.response.ListResponse;
import com.reamber.core.openai.model.response.file.FileDetails;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileDetailsSerializationTest {

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/files.json");

        final var om = new ObjectMapper();

        final var result = om.readValue(content, new TypeReference<ListResponse<FileDetails>>() {
        });

        assertEquals("list", result.getObject());
        assertEquals(2, result.getData().size());
        assertEquals(1613677385, result.getData().get(0).getCreated());
    }

}