package com.reamber.core.openai.model.request.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.model.request.model.Model;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @see <a href="https://platform.openai.com/docs/api-reference/fine-tunes">OpenAI Fine-tunes API</a>
 */
@Data
@Builder
public class FineTuningStartRequest {

    /**
     * <p>The ID of an uploaded file that contains training data.</p>
     * <p></p>
     * <p>Your dataset must be formatted as a JSONL file, where each training example is a JSON object with the keys "prompt" and "completion".</p>
     * <p>Additionally, you must upload your file with the purpose fine-tune.</p>
     */
    @JsonProperty("training_file")
    private String trainingFile;

    /**
     * <p>The ID of an uploaded file that contains validation data.</p>
     * <p></p>
     * <p>If you provide this file, the data is used to generate validation metrics periodically during fine-tuning.
     * These metrics can be viewed in the fine-tuning results file. Your train and validation data should be mutually exclusive.</p>
     * <p></p>
     * <p>Your dataset must be formatted as a JSONL file, where each validation example is a JSON object with the keys "prompt" and "completion".
     * Additionally, you must upload your file with the purpose fine-tune.</p>
     */
    @JsonProperty("validation_file")
    private String validationFile;

    /**
     * The name of the base model to fine-tune. You can select one of "ada", "babbage", "curie", "davinci", or a fine-tuned model created after 2022-04-21.
     */
    private Model model;

    /**
     * The number of epochs to train the model for. An epoch refers to one full cycle through the training dataset.
     */
    @JsonProperty("n_epochs")
    private Long nEpochs;

    /**
     * <p>The batch size to use for training. The batch size is the number of training examples used to train a single forward and backward pass.</p>
     * <p></p>
     * <p>By default, the batch size will be dynamically configured to be ~0.2% of the number of examples in the training set, capped at 256 - in general, we've found that larger batch sizes tend to work better for larger datasets.</p>
     */
    @JsonProperty("batch_size")
    private Long batchSize;

    /**
     * <p>The learning rate multiplier to use for training. The fine-tuning learning rate is the original learning rate used for pretraining multiplied by this value.</p>
     * <p></p>
     * <p>By default, the learning rate multiplier is the 0.05, 0.1, or 0.2 depending on final {@link FineTuningStartRequest#batchSize} (larger learning rates tend to perform better with larger batch sizes).</p>
     * <p>We recommend experimenting with values in the range 0.02 to 0.2 to see what produces the best results.</p>
     */
    @JsonProperty("learning_rate_multiplier")
    private Double learningRateMultiplier;

    /**
     * <p>The weight to use for loss on the prompt tokens. This controls how much the model tries to learn to generate the prompt (as compared to the completion which always has a weight of 1.0), and can add a stabilizing effect to training when completions are short.</p>
     * <p></p>
     * <p>If prompts are extremely long (relative to completions), it may make sense to reduce this weight so as to avoid over-prioritizing learning the prompt.</p>
     */
    @JsonProperty("prompt_loss_weight")
    private Double promptLossWeight;

    /**
     * <p>If set, we calculate classification-specific metrics such as accuracy and F-1 score using the validation set at the end of every epoch. These metrics can be viewed in the results file.</p>
     * <p></p>
     * <p>In order to compute classification metrics, you must provide a {@link FineTuningStartRequest#validationFile}. Additionally, you must specify {@link FineTuningStartRequest#classificationNClasses} for multiclass classification or {@link FineTuningStartRequest#classificationPositiveClass} for binary classification.</p>
     */
    @JsonProperty("compute_classification_metrics")
    private boolean computeClassificationMetrics;

    /**
     * <p>The number of classes in a classification task.</p>
     * <p></p>
     * <p>This parameter is required for multiclass classification.</p>
     */
    @JsonProperty("classification_n_classes")
    private Long classificationNClasses;

    /**
     * <p>The positive class in binary classification.</p>
     * <p></p>
     * <p>This parameter is needed to generate precision, recall, and F1 metrics when doing binary classification.</p>
     */
    @JsonProperty("classification_positive_class")
    private String classificationPositiveClass;

    /**
     * <p>If this is provided, we calculate F-beta scores at the specified beta values. The F-beta score is a generalization of F-1 score. This is only used for binary classification.</p>
     * <p></p>
     * <p>With a beta of 1 (i.e. the F-1 score), precision and recall are given the same weight. A larger beta score puts more weight on recall and less on precision. A smaller beta score puts more weight on precision and less on recall.</p>
     */
    @JsonProperty("classification_betas")
    private List<Long> classificationBetas;

    /**
     * <p>A string of up to 40 characters that will be added to your fine-tuned model name.</p>
     * <p></p>
     * <p>For example, a "custom-model-name" would produce a model name like ada:ft-your-org:custom-model-name-2022-02-15-04-21-04.</p>
     */
    private String suffix;
}