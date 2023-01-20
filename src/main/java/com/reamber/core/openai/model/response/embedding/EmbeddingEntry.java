package com.reamber.core.openai.model.response.embedding;

import lombok.Data;

import java.util.List;

/**
 * <a href="https://beta.openai.com/docs/api-reference/embeddings">Embeddings</a>
 */
@Data
public class EmbeddingEntry {

    private String object;

    private int index;

    private List<Double> embedding;
}