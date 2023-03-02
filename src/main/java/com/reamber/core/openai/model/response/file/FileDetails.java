package com.reamber.core.openai.model.response.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reamber.core.openai.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <a href="https://platform.openai.com/docs/api-reference/files">Files</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FileDetails extends BaseResponse {

    private String filename;

    private String purpose;

    private int bytes;

    private boolean deleted;

    private String status;

    @JsonProperty("status_details")
    private String statusDetails;
}