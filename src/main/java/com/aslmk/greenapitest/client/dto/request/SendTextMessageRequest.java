package com.aslmk.greenapitest.client.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SendTextMessageRequest(@NotNull @Valid InstanceAccessParameters instanceParameters,
                                     @NotBlank String chatId,
                                     @NotBlank String message) {}
