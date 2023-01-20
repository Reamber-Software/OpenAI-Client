package com.reamber.core.openai.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrganizationRequestInterceptor implements RequestInterceptor {

    final OrganizationRequestService organizationRequestService;

    @Override
    public void apply(RequestTemplate template) {
        template.header("OpenAI-Organization", organizationRequestService.getOrganisation());
    }
}
