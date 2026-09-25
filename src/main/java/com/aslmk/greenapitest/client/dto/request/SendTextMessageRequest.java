package com.aslmk.greenapitest.client.dto.request;

public record SendTextMessageRequest(InstanceAccessParameters instanceParameters,
                                     String chatId,
                                     String message) {}
