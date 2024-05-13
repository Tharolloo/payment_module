package io.paymentgateway.paymentmodule.NinePsbVasApi.services;

import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;
import io.paymentgateway.paymentmodule.coralPayDirectMoneyTransfer.DTO.response.FetchAccountTransactionResponse;
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
                .uri("http://sandbox1.coralpay.com:8080/paywithtransfer/moneytransfer/apis/partners/getAccountTransactions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(NinePSBVASAuthenticateResponse.class);
    }
}
