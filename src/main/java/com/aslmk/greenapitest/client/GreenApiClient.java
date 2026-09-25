package com.aslmk.greenapitest.client;

import com.aslmk.greenapitest.client.dto.FileMessageData;
import com.aslmk.greenapitest.client.dto.TextMessageData;
import com.aslmk.greenapitest.client.dto.request.InstanceAccessParameters;
import com.aslmk.greenapitest.client.dto.request.SendFileByUrlRequest;
import com.aslmk.greenapitest.client.dto.request.SendTextMessageRequest;
import com.aslmk.greenapitest.client.dto.response.InstanceSettingsResponse;
import com.aslmk.greenapitest.client.dto.response.SendMessageResponse;
import com.aslmk.greenapitest.client.dto.response.StateInstanceResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GreenApiClient {
    private final RestClient restClient;

    public GreenApiClient(RestClient.Builder restClientBuilder,
                          @Value("${green-api.base-url}") String baseUrl) {
        this.restClient = restClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    public InstanceSettingsResponse getSettings(InstanceAccessParameters parameters) {
        String endpointUrl = String.format("/waInstance%s/getSettings/%s",
                parameters.idInstance(), parameters.apiTokenInstance());

        return restClient.get()
                .uri(endpointUrl)
                .retrieve()
                .body(InstanceSettingsResponse.class);
    }

    public StateInstanceResponse getStateInstance(InstanceAccessParameters parameters) {
        String endpointUrl = String.format("/waInstance%s/getStateInstance/%s",
                parameters.idInstance(), parameters.apiTokenInstance());

        return restClient.get()
                .uri(endpointUrl)
                .retrieve()
                .body(StateInstanceResponse.class);
    }

    public SendMessageResponse sendMessage(SendTextMessageRequest request) {
        InstanceAccessParameters parameters = request.instanceParameters();
        String endpointUrl = String.format("/waInstance%s/sendMessage/%s",
                parameters.idInstance(), parameters.apiTokenInstance());

        return restClient.post()
                .uri(endpointUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new TextMessageData(request.chatId(), request.message()))
                .retrieve()
                .body(SendMessageResponse.class);
    }

    public SendMessageResponse sendFileByUrl(SendFileByUrlRequest request) {
        InstanceAccessParameters parameters = request.instanceParameters();
        String endpointUrl = String.format("/waInstance%s/sendFileByUrl/%s",
                parameters.idInstance(), parameters.apiTokenInstance());

        return restClient.post()
                .uri(endpointUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new FileMessageData(request.chatId(), request.urlFile(), request.fileName()))
                .retrieve()
                .body(SendMessageResponse.class);
    }
}
