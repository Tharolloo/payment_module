package io.paymentgateway.paymentmodule.NinePsbVasApi.services;

import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVasApiAirtimeTopUpRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVasApiAirtimeTopUpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class NinePSBVasApiServiceImpl implements NinePSBVasApiService {


    /*Documentation for the Nine PSB Vas Api testing and implementation written with each end
    point tested and making sure it is working properly.
     */
    private final RestClient restClient;

    //1. Authenticate
    @Override
    public NinePSBVASAuthenticateResponse authenticate(NinePSBVASAuthenticateRequest request) {

        return restClient
                .post()
                .uri("http://10.185.223.23:9090/identity/api/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(NinePSBVASAuthenticateResponse.class);
    }

    @Override
    public NinePSBVasApiAirtimeTopUpResponse topUp(NinePSBVasApiAirtimeTopUpRequest request) {

        return restClient
                .post()
                .uri("http://102.216.128.75:9090/vas/api/v1/topup/airtime")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " +"eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTY5MDk1OCwianRpIjoiYzJkNmJkZDgtYTI4NC00NjJhLTliNTMtM2YzZmZjMWQ5ZmQ4IiwiZXhwIjoxNzE1Njk4MTU4fQ.09LYwWCgwiRiqT4BQEg9SPQbQ0lLLzkfae3GI7pcbd6HzlF3PVHhiiL7zu1mz2nogDH340Zg0F1UQvT_aPP-mg")
                        .body(request)
                .retrieve()
                .body(NinePSBVasApiAirtimeTopUpResponse.class);

    }
}
