package com.financomp.demo;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class CustomUriBuilder {

    private String baseUrl;

    private CustomUriBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static CustomUriBuilder fromBaseUrl(String baseUrl) {
        return new CustomUriBuilder(baseUrl);
    }

    public CustomUriBuilder path(String path) {
        this.baseUrl = UriComponentsBuilder.fromUriString(baseUrl).path(path).build().toUriString();
        return this;
    }

    public CustomUriBuilder buildAndExpand(Object... uriVariables) {
        this.baseUrl = UriComponentsBuilder.fromUriString(baseUrl).buildAndExpand(uriVariables).toUriString();
        return this;
    }

    public URI toUri() {
        return URI.create(baseUrl);
    }
}
