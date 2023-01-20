package com.reamber.core.openai.model.response.finetune;

import com.reamber.core.openai.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FineTuningEvent extends BaseResponse {

    private String level;

    private String message;
}