package com.reamber.core.openai.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorizationRequestInterceptor implements RequestInterceptor {

    final AuthorizationRequestService authorizationRequestService;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + authorizationRequestService.getAuthorizationKey());
    }
}
