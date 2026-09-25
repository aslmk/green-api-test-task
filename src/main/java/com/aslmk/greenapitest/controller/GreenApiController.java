package com.aslmk.greenapitest.controller;

import com.aslmk.greenapitest.client.GreenApiClient;
import com.aslmk.greenapitest.client.dto.request.InstanceAccessParameters;
import com.aslmk.greenapitest.client.dto.request.SendFileByUrlRequest;
import com.aslmk.greenapitest.client.dto.request.SendTextMessageRequest;
import com.aslmk.greenapitest.client.dto.response.InstanceSettingsResponse;
import com.aslmk.greenapitest.client.dto.response.SendMessageResponse;
import com.aslmk.greenapitest.client.dto.response.StateInstanceResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class GreenApiController {
    private final GreenApiClient apiClient;

    public GreenApiController(GreenApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @PostMapping("/settings")
    public InstanceSettingsResponse getSettings(@Valid @RequestBody InstanceAccessParameters request) {
        return apiClient.getSettings(request);
    }

    @PostMapping("/state")
    public StateInstanceResponse getStateInstance(@Valid @RequestBody InstanceAccessParameters request) {
        return apiClient.getStateInstance(request);
    }

    @PostMapping("/text-message")
    public SendMessageResponse sendTextMessage(@Valid @RequestBody SendTextMessageRequest request) {
        return apiClient.sendMessage(request);
    }

    @PostMapping("/file-message")
    public SendMessageResponse sendFileMessage(@Valid @RequestBody SendFileByUrlRequest request) {
        return apiClient.sendFileByUrl(request);
    }
}
