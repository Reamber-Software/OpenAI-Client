package com.reamber.core.openai.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public abstract class BaseResponse {

    private String id;

    private String object;

    @JsonAlias({"created_at"})
    private long created;

    private BaseError error;

    public boolean isSuccess() {
        return error == null;
    }

    public boolean isError() {
        return error != null;
    }
}
