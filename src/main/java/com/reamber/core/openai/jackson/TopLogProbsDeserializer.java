package com.reamber.core.openai.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.reamber.core.openai.model.response.completion.LogprobEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopLogProbsDeserializer extends JsonDeserializer<List<LogprobEntry>> {

    @Override
    public List<LogprobEntry> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {

        final var list = new ArrayList<LogprobEntry>();
        final ArrayNode node = jsonParser.getCodec().readTree(jsonParser);

        final var iterator = node.elements();
        while (iterator.hasNext()) {

            final var element = iterator.next().fields();
            final var field = element.next();

            list.add(new LogprobEntry(field.getKey(), field.getValue().asDouble()));
        }

        return list;
    }
}
