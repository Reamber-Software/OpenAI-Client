[![pipeline status](https://gitlab.com/reamber/core/openai-client/badges/master/pipeline.svg)](https://gitlab.com/reamber/core/openai-client/-/commits/master)
[![coverage report](https://gitlab.com/reamber/core/openai-client/badges/master/coverage.svg)](https://gitlab.com/reamber/core/openai-client/-/commits/master)
[![Latest Release](https://gitlab.com/reamber/core/openai-client/-/badges/release.svg)](https://gitlab.com/reamber/core/openai-client/-/releases)

# OpenAI Java Client

Basic OpenFeign Client to access the OpenAI API at https://api.openai.com


# Setup

    final var client = Feign.builder()
    .requestInterceptor(new AuthorizationRequestInterceptor(() -> "KEY"))
    .requestInterceptor(new OrganizationRequestInterceptor(() -> "ORG"))
    .encoder(new JacksonEncoder())
    .decoder(new JacksonDecoder())
    .logger(new Slf4jLogger())
    .logLevel(Logger.Level.HEADERS)
    .target(OpenAiClient.class, "https://api.openai.com");

# Maven Repository

TBD