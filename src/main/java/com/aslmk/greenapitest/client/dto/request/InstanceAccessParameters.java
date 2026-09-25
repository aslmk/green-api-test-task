package com.aslmk.greenapitest.client.dto.request;

import jakarta.validation.constraints.NotBlank;

public record InstanceAccessParameters(
        @NotBlank String idInstance,
        @NotBlank String apiTokenInstance) {}
