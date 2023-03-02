package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reamber.core.openai.model.request.EmbeddingRequest;
import com.reamber.core.openai.model.response.embedding.Embedding;
import com.reamber.core.openai.model.request.model.Model;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmbeddingSerializationTest extends BaseTest {

    @Test
    void testSerialize() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/embeddings.json");

        final var request = EmbeddingRequest.builder()
                .model(Model.TEXT_EMBEDDING_ADA_002)
                .input("This is a test")
                .user("OpenAI User")
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/embedding.json");

        final var om = new ObjectMapper();

        final var result = om.readValue(content, Embedding.class);

        assertEquals("list", result.getObject());
        assertEquals(1, result.getData().size());
        assertEquals(1536, result.getData().get(0).getEmbedding().size());
    }

}