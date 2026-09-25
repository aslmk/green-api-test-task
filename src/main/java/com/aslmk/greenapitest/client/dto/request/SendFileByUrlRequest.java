package com.aslmk.greenapitest.client.dto.request;

public record SendFileByUrlRequest(InstanceAccessParameters instanceParameters,
                                   String chatId,
                                   String urlFile,
                                   String fileName) {}
