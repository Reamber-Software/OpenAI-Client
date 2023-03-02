package com.reamber.core.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reamber.core.openai.model.request.finetune.FineTuningStartRequest;
import com.reamber.core.openai.model.response.finetune.FineTuningResult;
import com.reamber.core.openai.model.request.model.Model;
import com.reamber.core.openai.util.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
class FineTuningSerializationTest extends BaseTest {

    @Test
    void testSerialize() throws JsonProcessingException {

        final var expected = FileUtil.getContent("requests/finetune.json");

        final var request = FineTuningStartRequest.builder()
                .trainingFile("fineTuneFile")
                .validationFile("validationTuneFile")
                .model(Model.CURIE)
                .nEpochs(4L)
                .batchSize(0L)
                .learningRateMultiplier(0.05)
                .promptLossWeight(0.01D)
                .computeClassificationMetrics(false)
                .classificationNClasses(1L)
                .classificationPositiveClass("Test")
                .classificationBetas(List.of(1L))
                .suffix("curie:custom-model")
                .build();

        final var result = getObjectMapper().writeValueAsString(request);

        assertEquals(trim(expected), trim(result));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {

        final var content = FileUtil.getContent("responses/finetune.json");

        final var result = getObjectMapper().readValue(content, FineTuningResult.class);


        assertEquals("fine-tune", result.getObject());
        assertNotNull(result.getHyperparams());
        assertNotNull(result.getResultFiles());
    }

}