package com.reamber.core.openai.model.response.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Hyperparams {

    @JsonProperty("batch_size")
    private Integer batchSize;

    @JsonProperty("n_epochs")
    private Integer nEpochs;

    @JsonProperty("prompt_loss_weight")
    private Object promptLossWeight;

    @JsonProperty("learning_rate_multiplier")
    private Object learningRateMultiplier;
}