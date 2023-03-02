package com.reamber.core.openai.model.response.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.model.BaseResponse;
import com.reamber.core.openai.model.response.file.FileDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <a href="https://platform.openai.com/docs/api-reference/fine-tunes">Fine-tunes</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FineTuningResult extends BaseResponse {

    @JsonProperty("updated_at")
    private Long updatedAt;

    private String model;

    @JsonProperty("hyperparams")
    private Hyperparams hyperparams;

    @JsonProperty("fine_tuned_model")
    private String fineTunedModel;

    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("events")
    private List<FineTuningEvent> events;

    @JsonProperty("status")
    private String status;

    @JsonProperty("result_files")
    private List<FileDetails> resultFiles;

    @JsonProperty("training_files")
    private List<FileDetails> trainingFiles;

    @JsonProperty("validation_files")
    private List<FileDetails> validationFiles;
}