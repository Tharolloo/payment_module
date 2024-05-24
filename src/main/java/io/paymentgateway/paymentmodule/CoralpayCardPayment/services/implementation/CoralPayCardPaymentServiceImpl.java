package io.paymentgateway.paymentmodule.CoralpayCardPayment.services.implementation;

import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.CoralCardRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.CoralPayCardResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.services.CoralPayCardPaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@AllArgsConstructor
public class CoralPayCardPaymentServiceImpl implements CoralPayCardPaymentService {

    private final RestClient restClient;

    private final WebClient webClient;

    private final RestTemplate restTemplate;
    @Override
    public CoralPayCardResponse authenticate(CoralCardRequest request) {

        return restClient
                .post()
                .uri("https://testdev.coralpay.com:5000/GwApi/api/v1/Authentication")
                .contentType(MediaType.APPLICATION_JSON)
                //.header(HttpHeaders.AUTHORIZATION, "Basic "+ )
                .body(request)
                .retrieve()
                .body(CoralPayCardResponse.class);

    }

}
