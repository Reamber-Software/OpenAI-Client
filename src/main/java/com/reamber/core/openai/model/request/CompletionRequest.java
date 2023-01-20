package com.reamber.core.openai.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.OpenAiClient;
import com.reamber.core.openai.model.response.model.Model;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://beta.openai.com/docs/api-reference/completions/create#completions/create-model">OpenAI Completions API</a>
 */
@Data
@Builder
public class CompletionRequest {

    /**
     * ID of the model to use. You can use the List models API {@link OpenAiClient#getModels()} or {@link Model} to see all of your available models.
     *
     * @see <a href="https://beta.openai.com/docs/models/overview">Model overview</a>
     */
    private final Model model;

    /**
     * The prompt(s) to generate completions for, encoded as a string, array of strings, array of tokens, or array of token arrays.
     * Note that <|endoftext|> is the document separator that the model sees during training, so if a prompt is not specified the model will generate as if from the beginning of a new document.
     */
    @Singular("prompt")
    @JsonProperty("prompt")
    private List<String> prompts;

    /**
     * The suffix that comes after a completion of inserted text.
     */
    private String suffix;

    /**
     * <p>The maximum number of <a href="https://beta.openai.com/tokenizer">tokens</a> to generate in the completion.</p>
     * The token count of your prompt plus max_tokens cannot exceed the model's context length. Most models have a context length of 2048 tokens (except for the newest models, which support 4096).
     */
    @JsonProperty("max_tokens")
    private int maxTokens;

    /**
     * What sampling <a href="https://towardsdatascience.com/how-to-sample-from-language-models-682bceb97277">temperature</a> to use. Higher values means the model will take more risks. Try 0.9 for more creative applications, and 0 (argmax sampling) for ones with a well-defined answer.
     * <p>We generally recommend altering this or {@link CompletionRequest#topP} but not both.</p>
     */
    private Double temperature;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * <p>We generally recommend altering this or {@link CompletionRequest#temperature} but not both.</p>
     */
    @JsonProperty("top_p")
    private Double topP;

    /**
     * <p>How many completions to generate for each prompt.</p>
     * Note: Because this parameter generates many completions, it can quickly consume your token quota. Use carefully and ensure that you have reasonable settings for {@link CompletionRequest#maxTokens} and {@link CompletionRequest#stops}.
     */
    private Long n;

    /**
     * Whether to stream back partial progress. If set, tokens will be sent as data-only  <a href="https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#event_stream_format">server-sent events</a> as they become available, with the stream terminated by a data: [DONE] message.
     */
    private boolean stream;

    /**
     * Include the log probabilities on the logprobs most likely tokens, as well the chosen tokens. For example, if logprobs is 5, the API will return a list of the 5 most likely tokens. The API will always return the logprob of the sampled token, so there may be up to logprobs+1 elements in the response.
     */
    private Long logprobs;

    /**
     * Echo back the prompt in addition to the completion
     */
    private boolean echo;

    /**
     * Up to 4 sequences where the API will stop generating further tokens. The returned text will not contain the stop sequence.
     */
    @Singular("stop")
    @JsonProperty("stop")
    private List<String> stops;

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear in the text so far, increasing the model's likelihood to talk about new topics.
     */
    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far, decreasing the model's likelihood to repeat the same line verbatim.
     */
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;

    /**
     * <p>Generates bestOf completions server-side and returns the "best" (the one with the highest log probability per token). Results cannot be streamed.</p>
     * <p>When used with {@link CompletionRequest#n}, bestOf controls the number of candidate completions and {@link CompletionRequest#n} specifies how many to return – bestOf must be greater than {@link CompletionRequest#n}.</p>
     * <br>
     * <p> Note: Because this parameter generates many completions, it can quickly consume your token quota. Use carefully and ensure that you have reasonable settings for {@link CompletionRequest#maxTokens} and {@link CompletionRequest#stops}.</p>
     */
    @JsonProperty("best_of")
    private Long bestOf;

    /**
     * <p>Modify the likelihood of specified tokens appearing in the completion.</p>
     * <br>
     * <p>Accepts a json object that maps tokens (specified by their token ID in the GPT tokenizer) to an associated bias value from -100 to 100. You can use this <a href="https://beta.openai.com/tokenizer">tokenizer tool</a> (which works for both GPT-2 and GPT-3) to convert text to token IDs. Mathematically, the bias is added to the logits generated by the model prior to sampling. The exact effect will vary per model, but values between -1 and 1 should decrease or increase likelihood of selection; values like -100 or 100 should result in a ban or exclusive selection of the relevant token.</p>
     * <br>
     * <p> As an example, you can pass {"50256": -100} to prevent the <|endoftext|> token from being generated.
     */
    @JsonProperty("logit_bias")
    private Map<String, Long> logitBias;

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    private String user;


}
