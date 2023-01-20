package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reamber.core.openai.model.request.EditRequest;
import com.reamber.core.openai.model.response.Choice;
import com.reamber.core.openai.model.response.edit.Edit;
import com.reamber.core.openai.model.response.model.Model;
import com.reamber.core.openai.util.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
class EditSerializationTest extends BaseTest {

    @Test
    void testSerialize() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/edit.json");

        final var request = EditRequest.builder()
                .model(Model.TEXT_DAVINCI_EDIT_001)
                .input("This is a")
                .instruction("finish the sentence")
                .n(1L)
                .temperature(0.9)
                .topP(0.0)
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/edit.json");

        final var result = getObjectMapper().readValue(content, Edit.class);

        final var choice = new Choice();
        choice.setText("What day of the week is it?\n");
        choice.setIndex(0);

        assertEquals("edit", result.getObject());
        assertEquals(List.of(choice), result.getChoices());
    }

}