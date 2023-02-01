package com.reamber.core.openai.model.request;

import com.reamber.core.openai.OpenAIClient;
import com.reamber.core.openai.model.response.model.Model;
import lombok.Builder;
import lombok.Data;

/**
 * @see <a href="https://beta.openai.com/docs/api-reference/embeddings/create">OpenAI Embeddings API</a>
 */
@Data
@Builder
public class EmbeddingRequest {

    /**
     * ID of the model to use. You can use the List models API {@link OpenAIClient#getModels()} or {@link Model} to see all of your available models.
     *
     * @see <a href="https://beta.openai.com/docs/models/overview">Model overview</a>
     */
    private Model model;

    /**
     * Input text to get embeddings for, encoded as a string or array of tokens. To get embeddings for multiple inputs in a single request, pass an array of strings or array of token arrays. Each input must not exceed 8192 tokens in length.
     */
    private String input;

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    private String user;
}