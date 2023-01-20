package com.reamber.core.openai.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.OpenAiClient;
import com.reamber.core.openai.model.response.model.Model;
import lombok.Builder;
import lombok.Data;

/**
 * @see <a href="https://beta.openai.com/docs/api-reference/edits/create">OpenAI Edits API</a>
 */
@Data
@Builder
public class EditRequest {

    /**
     * ID of the model to use. You can use the List models API {@link OpenAiClient#getModels()} or {@link Model} to see all of your available models.
     *
     * @see <a href="https://beta.openai.com/docs/models/overview">Model overview</a>
     */
    private final Model model;

    /**
     * The input text to use as a starting point for the edit.
     */
    private String input;

    /**
     * The instruction that tells the model how to edit the prompt.
     */
    private String instruction;

    /**
     * How many edits to generate for the input and instruction.
     */
    private Long n;

    /**
     * What sampling <a href="https://towardsdatascience.com/how-to-sample-from-language-models-682bceb97277">temperature</a> to use. Higher values means the model will take more risks. Try 0.9 for more creative applications, and 0 (argmax sampling) for ones with a well-defined answer.
     * <p>We generally recommend altering this or {@link EditRequest#topP} but not both.</p>
     */
    private Double temperature;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * <p>We generally recommend altering this or {@link EditRequest#temperature} but not both.</p>
     */
    @JsonProperty("top_p")
    private Double topP;

}
