package com.reamber.core.openai.util;

import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor
public class FileUtil {

    public static String getContent(String filePath) {

        try (final var file = FileUtil.class.getClassLoader().getResourceAsStream(filePath)) {

            return new String(file.readAllBytes(), StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new IllegalArgumentException("Failure loading file content for path: " + filePath, e);
        }
    }
}
