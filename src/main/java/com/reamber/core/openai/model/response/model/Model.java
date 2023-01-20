package com.reamber.core.openai.model.response.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * <a href="https://beta.openai.com/docs/api-reference/models">Model</a>
 */
@RequiredArgsConstructor
public enum Model {

    ADA("ada"),

    ADA_CODE_SEARCH_CODE("ada-code-search-code"),

    ADA_CODE_SEARCH_TEXT("ada-code-search-text"),

    ADA_SEARCH_DOCUMENT("ada-search-document"),

    ADA_SEARCH_QUERY("ada-search-query"),

    ADA_SIMILARITY("ada-similarity"),

    ADA_2020_05_03("ada:2020-05-03"),

    AUDIO_TRANSCRIBE_001("audio-transcribe-001"),

    BABBAGE("babbage"),

    BABBAGE_CODE_SEARCH_CODE("babbage-code-search-code"),

    BABBAGE_CODE_SEARCH_TEXT("babbage-code-search-text"),

    BABBAGE_SEARCH_DOCUMENT("babbage-search-document"),

    BABBAGE_SEARCH_QUERY("babbage-search-query"),

    BABBAGE_SIMILARITY("babbage-similarity"),

    BABBAGE_2020_05_03("babbage:2020-05-03"),

    CODE_CUSHMAN_001("code-cushman-001"),

    CODE_DAVINCI_002("code-davinci-002"),

    CODE_DAVINCI_EDIT_001("code-davinci-edit-001"),

    CODE_SEARCH_ADA_CODE_001("code-search-ada-code-001"),

    CODE_SEARCH_ADA_TEXT_001("code-search-ada-text-001"),

    CODE_SEARCH_BABBAGE_CODE_001("code-search-babbage-code-001"),

    CODE_SEARCH_BABBAGE_TEXT_001("code-search-babbage-text-001"),

    CURIE("curie"),

    CURIE_INSTRUCT_BETA("curie-instruct-beta"),

    CURIE_SEARCH_DOCUMENT("curie-search-document"),

    CURIE_SEARCH_QUERY("curie-search-query"),

    CURIE_SIMILARITY("curie-similarity"),

    CURIE_2020_05_03("curie:2020-05-03"),

    CUSHMAN_2020_05_03("cushman:2020-05-03"),

    DAVINCI("davinci"),

    DAVINCI_IF_300("davinci-if:3.0.0"),

    DAVINCI_INSTRUCT_BETA("davinci-instruct-beta"),

    DAVINCI_INSTRUCT_BETA_200("davinci-instruct-beta:2.0.0"),

    DAVINCI_SEARCH_DOCUMENT("davinci-search-document"),

    DAVINCI_SEARCH_QUERY("davinci-search-query"),

    DAVINCI_SIMILARITY("davinci-similarity"),

    DAVINCI_2020_05_03("davinci:2020-05-03"),

    IF_CURIE_V2("if-curie-v2"),

    IF_DAVINCI_V2("if-davinci-v2"),

    IF_DAVINCI_300("if-davinci:3.0.0"),

    TEXT_ADA_001("text-ada-001"),

    TEXT_BABBAGE_001("text-babbage-001"),

    TEXT_CURIE_001("text-curie-001"),

    TEXT_DAVINCI_001("text-davinci-001"),

    TEXT_DAVINCI_002("text-davinci-002"),

    TEXT_DAVINCI_003("text-davinci-003"),

    TEXT_DAVINCI_EDIT_001("text-davinci-edit-001"),

    TEXT_DAVINCI_INSERT_001("text-davinci-insert-001"),

    TEXT_DAVINCI_INSERT_002("text-davinci-insert-002"),

    TEXT_EMBEDDING_ADA_002("text-embedding-ada-002"),

    TEXT_SEARCH_ADA_DOC_001("text-search-ada-doc-001"),

    TEXT_SEARCH_ADA_QUERY_001("text-search-ada-query-001"),

    TEXT_SEARCH_BABBAGE_DOC_001("text-search-babbage-doc-001"),

    TEXT_SEARCH_BABBAGE_QUERY_001("text-search-babbage-query-001"),

    TEXT_SEARCH_CURIE_DOC_001("text-search-curie-doc-001"),

    TEXT_SEARCH_CURIE_QUERY_001("text-search-curie-query-001"),

    TEXT_SEARCH_DAVINCI_DOC_001("text-search-davinci-doc-001"),

    TEXT_SEARCH_DAVINCI_QUERY_001("text-search-davinci-query-001"),

    TEXT_SIMILARITY_ADA_001("text-similarity-ada-001"),

    TEXT_SIMILARITY_BABBAGE_001("text-similarity-babbage-001"),

    TEXT_SIMILARITY_CURIE_001("text-similarity-curie-001"),

    TEXT_SIMILARITY_DAVINCI_001("text-similarity-davinci-001");

    private final String modelName;

    @JsonValue
    public String getModel() {
        return modelName;
    }
}