package com.reamber.core.openai;

import com.reamber.core.openai.interceptor.AuthorizationRequestInterceptor;
import com.reamber.core.openai.interceptor.OrganizationRequestInterceptor;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
class ClientTest {

    @Test
    void testClient() {

        final var client = Feign.builder()
                .requestInterceptor(new AuthorizationRequestInterceptor(() -> "KEY"))
                .requestInterceptor(new OrganizationRequestInterceptor(() -> "ORG"))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.HEADERS)
                .target(OpenAIClient.class, "https://api.openai.com");

        assertNotNull(client);
    }
}
