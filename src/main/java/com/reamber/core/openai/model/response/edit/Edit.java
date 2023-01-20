package com.reamber.core.openai.model.response.edit;

import com.reamber.core.openai.model.BaseResponse;
import com.reamber.core.openai.model.response.Choice;
import com.reamber.core.openai.model.response.Usage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <a href="https://beta.openai.com/docs/api-reference/edits">Edits</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Edit extends BaseResponse {

    private Usage usage;

    private List<Choice> choices;

}