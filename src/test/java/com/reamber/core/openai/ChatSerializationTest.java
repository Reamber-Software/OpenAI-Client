package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reamber.core.openai.model.request.chat.ChatMessage;
import com.reamber.core.openai.model.request.chat.ChatRequest;
import com.reamber.core.openai.model.request.chat.ChatRole;
import com.reamber.core.openai.model.request.model.Model;
import com.reamber.core.openai.model.response.chat.Chat;
import com.reamber.core.openai.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatSerializationTest extends BaseTest {

    @Test
    void testSerialize() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/chat.json");

        final var message = ChatMessage.builder()
                .role(ChatRole.USER)
                .content("Please write Hello World")
                .build();

        final var request = ChatRequest.builder()
                .model(Model.GPT_3_5_TURBO)
                .messages(List.of(message))
                .maxTokens(100)
                .temperature(0.0)
                .topP(0.0)
                .n(1L)
                .stream(false)
                .presencePenalty(0.0)
                .frequencyPenalty(0.0)
                .user("OpenAI User")
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/chat.json");

        final var result = getObjectMapper().readValue(content, Chat.class);

        final var choice = result.getChoices().get(0);

        assertEquals("stop", choice.getFinishReason());
        assertEquals(ChatRole.ASSISTANT, choice.getMessage().getRole());
    }

}