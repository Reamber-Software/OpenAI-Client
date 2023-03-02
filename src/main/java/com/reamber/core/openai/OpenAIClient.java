package com.reamber.core.openai;

import com.reamber.core.openai.model.request.CompletionRequest;
import com.reamber.core.openai.model.request.EditRequest;
import com.reamber.core.openai.model.request.EmbeddingRequest;
import com.reamber.core.openai.model.request.chat.ChatRequest;
import com.reamber.core.openai.model.request.finetune.FineTuningStartRequest;
import com.reamber.core.openai.model.request.image.ImageEditRequest;
import com.reamber.core.openai.model.request.image.ImageGenerationRequest;
import com.reamber.core.openai.model.request.image.ImageVariationRequest;
import com.reamber.core.openai.model.request.moderation.ModerationRequest;
import com.reamber.core.openai.model.response.ListResponse;
import com.reamber.core.openai.model.response.chat.Chat;
import com.reamber.core.openai.model.response.completion.Completion;
import com.reamber.core.openai.model.response.edit.Edit;
import com.reamber.core.openai.model.response.embedding.Embedding;
import com.reamber.core.openai.model.response.file.FileDetails;
import com.reamber.core.openai.model.response.finetune.FineTuningEvent;
import com.reamber.core.openai.model.response.finetune.FineTuningResult;
import com.reamber.core.openai.model.response.image.ImageResponse;
import com.reamber.core.openai.model.response.model.ModelDetails;
import com.reamber.core.openai.model.response.moderation.Moderation;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.io.File;

@Headers({
        "Content-Type: application/json"
})
public interface OpenAIClient {

    /**
     * Lists the currently available models, and provides basic information about each one such as the owner and availability.
     */
    @RequestLine("GET /v1/models")
    ListResponse<ModelDetails> getModels();

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and permissioning.
     *
     * @param modelId The ID of the model to use for this request.
     * @return the corresponding {@link ModelDetails} for the given modelId.
     */
    @RequestLine("GET /v1/models/{modelId}")
    ModelDetails getModel(@Param("modelId") String modelId);

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization.
     *
     * @param model - The ID of the fine-tunened model
     * @return details about the model
     */
    @RequestLine("DELETE /v1/models/{model}")
    ModelDetails deleteModel(@Param("model") String model);

    /**
     * Creates a completion for the provided prompt and parameters.
     *
     * @param request The request with a prompt and additional parameters.
     * @return The model will return one or more predicted completions, and can also return the probabilities of alternative tokens at each position.
     */
    @RequestLine("POST /v1/completions")
    Completion complete(CompletionRequest request);

    /**
     * Creates a completion for the chat message
     *
     * @param request The request with a message and additional parameters.
     * @return The model will return the continued chat conversation or completion.
     */
    @RequestLine("POST /v1/chat/completions")
    Chat chat(ChatRequest request);

    /**
     * Creates a new edit for the provided input, instruction, and parameters.
     *
     * @param request The request with an input and instructions.
     * @return The model will return an edited version of the prompt.
     */
    @RequestLine("POST /v1/edits")
    Edit edit(EditRequest request);

    /**
     * Creates an image given a prompt.
     *
     * @param request The request with a prompt.
     * @return The model will generate a new image.
     */
    @RequestLine("POST /v1/images/generations")
    ImageResponse generateImage(ImageGenerationRequest request);

    /**
     * Creates an edited or extended image given an original image and a prompt.
     *
     * @param request The request with base image and prompt.
     * @return The model will generate a new image.
     */
    @RequestLine("POST /v1/images/edits")
    @Headers("Content-Type: multipart/form-data")
    ImageResponse editImage(ImageEditRequest request);

    /**
     * Creates a variation of a given image.
     *
     * @param request The request with an image.
     * @return The model will generate a new image.
     */
    @RequestLine("POST /v1/images/variations")
    @Headers("Content-Type: multipart/form-data")
    ImageResponse variateImage(ImageVariationRequest request);

    /**
     * Creates an embedding vector representing the input text.
     *
     * @param request The request with a model and input
     * @return a vector representation of a given input that can be easily consumed by machine learning models and algorithms
     */
    @RequestLine("POST /v1/embeddings")
    Embedding generateEmbedding(EmbeddingRequest request);

    /**
     * Returns a list of files that belong to the user's organization.
     *
     * @return list of files in the organization
     */
    @RequestLine("GET /v1/files")
    ListResponse<FileDetails> getFiles();

    /**
     * Upload a file that contains document(s) to be used across various endpoints/features.
     * Currently, the size of all the files uploaded by one organization can be up to 1 GB.
     *
     * @return details of the uploaded file
     */
    @RequestLine("POST /v1/files")
    @Headers("Content-Type: multipart/form-data")
    FileDetails uploadFile(@Param("file") File file, @Param("purpose") String purpose);

    /**
     * Delete a file.
     *
     * @param fileId - The ID of the file to use for this request
     * @return details of the deleted file
     */
    @RequestLine("DELETE /v1/files/{fileId}")
    FileDetails deleteFile(@Param("fileId") String fileId);

    /**
     * Returns information about a specific file.
     *
     * @param fileId - The ID of the file to use for this request
     * @return details of the deleted file
     */
    @RequestLine("GET /v1/files/{fileId}")
    FileDetails getFile(@Param("fileId") String fileId);

    /**
     * Returns the contents of the specified file
     *
     * @param fileId - The ID of the file to use for this request
     * @return details of the deleted file
     */
    @RequestLine("GET /v1/files/{fileId}/content")
    String getFileContent(@Param("fileId") String fileId);

    /**
     * Creates a job that fine-tunes a specified model from a given dataset.
     *
     * @param fineTuningStartRequest - fine tune files to train the model
     * @return includes details of the enqueued job including job status and the name of the fine-tuned models once complete
     */
    @RequestLine("POST /v1/fine-tunes")
    FineTuningResult startFineTuning(FineTuningStartRequest fineTuningStartRequest);

    /**
     * Immediately cancel a fine-tune job.
     *
     * @param fineTuningId - The ID of the fine-tune job
     * @return the details about corresponding fine tune job
     */
    @RequestLine("POST /v1/fine-tunes/{fineTuneId}/cancel")
    FineTuningResult cancelFineTuning(@Param("fineTuneId") Long fineTuningId);

    /**
     * List your organization's fine-tuning jobs
     *
     * @return your organization's fine-tuning jobs
     */
    @RequestLine("GET /v1/fine-tunes")
    ListResponse<FineTuningResult> getFineTunings();

    /**
     * Gets info about the fine-tune job.
     *
     * @param fineTuningId - The ID of the fine-tune job
     * @return the details about corresponding fine tune job
     */
    @RequestLine("GET /v1/fine-tunes/{fineTuneId}")
    FineTuningResult getFineTuning(@Param("fineTuneId") Long fineTuningId);

    /**
     * Get fine-grained status updates for a fine-tune job.
     *
     * @param fineTuningId - The ID of the fine-tune job
     * @return status updates for the corresponding fine tune job.
     */
    @RequestLine("GET /v1/fine-tunes/{fineTuneId}/events")
    ListResponse<FineTuningEvent> getFineTuningEvents(@Param("fineTuneId") Long fineTuningId);

    /**
     * Given an input text, outputs if the model classifies it as violating OpenAI's content policy.
     *
     * @param request - The request with an input text
     * @return if the input text is flagged as violating the content policy and in which category
     */
    @RequestLine("GET /v1/files/{fileId}/content")
    Moderation moderate(ModerationRequest request);
}