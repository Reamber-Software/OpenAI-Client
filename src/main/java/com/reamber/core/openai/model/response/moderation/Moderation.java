package com.reamber.core.openai.model.response.moderation;

import com.reamber.core.openai.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Moderation extends BaseResponse {

    private String model;

    private List<ModerationEntry> results;
}