package com.reamber.core.openai.model.response.completion;

import com.reamber.core.openai.model.BaseResponse;
import com.reamber.core.openai.model.response.Choice;
import com.reamber.core.openai.model.response.Usage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <a href="https://platform.openai.com/docs/api-reference/completions">Completions</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Completion extends BaseResponse {

    private String model;

    private Usage usage;

    private List<Choice> choices;
}