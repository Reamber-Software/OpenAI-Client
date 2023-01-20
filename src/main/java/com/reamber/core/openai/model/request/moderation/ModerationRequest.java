package com.reamber.core.openai.model.request.moderation;

import lombok.Builder;
import lombok.Data;

/**
 * @see <a href="https://beta.openai.com/docs/api-reference/moderations/create">OpenAI Moderation API</a>
 */
@Data
@Builder
public class ModerationRequest {

    /**
     * Two content moderations models are available: {@link ModerationModel#STABLE} and {@link ModerationModel#LATEST}.
     * <p></p>
     * <p>The default is {@link ModerationModel#LATEST} which will be automatically upgraded over time.</p>
     * <p>This ensures you are always using our most accurate model. If you use {@link ModerationModel#STABLE}, we will provide advanced notice before updating the model.</p>
     * <p>Accuracy of {@link ModerationModel#STABLE} may be slightly lower than for {@link ModerationModel#LATEST}.</p>
     */
    private ModerationModel model;

    /**
     * The input text to classify
     */
    private String input;


}