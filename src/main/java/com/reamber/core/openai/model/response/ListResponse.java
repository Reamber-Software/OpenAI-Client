package com.reamber.core.openai.model.response;

import com.reamber.core.openai.model.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class ListResponse<T extends BaseResponse> {

    private String object;

    private List<T> data;
}
