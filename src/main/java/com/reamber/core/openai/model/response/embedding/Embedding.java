package com.reamber.core.openai.model.response.embedding;

import com.reamber.core.openai.model.BaseResponse;
import com.reamber.core.openai.model.response.Usage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <a href="https://beta.openai.com/docs/api-reference/embeddings">Embeddings</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Embedding extends BaseResponse {

    private List<EmbeddingEntry> data;

    private String model;

    private Usage usage;
}