package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reamber.core.openai.model.request.CompletionRequest;
import com.reamber.core.openai.model.response.completion.Completion;
import com.reamber.core.openai.model.response.model.Model;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompletionSerializationTest extends BaseTest {

    @Test
    void testSerialize() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/completion.json");

        final var request = CompletionRequest.builder()
                .model(Model.TEXT_DAVINCI_003)
                .prompt("This is a test")
                .suffix("It indeed is.")
                .maxTokens(10)
                .temperature(0.0)
                .topP(0.0)
                .n(1L)
                .stream(false)
                .logprobs(1L)
                .echo(false)
                .stop(".")
                .presencePenalty(0.0)
                .frequencyPenalty(0.0)
                .bestOf(1L)
                .logitBias(Map.of("50256", 100L))
                .user("OpenAI User")
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/completion.json");

        final var result = getObjectMapper().readValue(content, Completion.class);

        final var topLogprobs = result.getChoices().get(0).getLogprobs().getTopLogprobs();

        assertEquals(",", topLogprobs.get(0).getKey());
        assertEquals(-1.2091616, topLogprobs.get(0).getValue());

        assertEquals(" email", topLogprobs.get(6).getKey());
        assertEquals(-0.6803218, topLogprobs.get(6).getValue());
    }

}