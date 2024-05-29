package io.paymentgateway.paymentmodule.CoralpayCardPayment.services.implementation;

import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.CoralCardRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.VergePaymentInvokePaymentRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.CoralPayCardResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.VergePaymentInvokePaymentResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.services.CoralPayCardPaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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

    @Override
    public VergePaymentInvokePaymentResponse invokePayment(VergePaymentInvokePaymentRequest paymentRequest) {

        String value = "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTUxMiIsInR5c" +
                "CI6IkpXVCJ9.eyJqdGkiOiI3YTExODAzOC0wNzkzLTRhNmEtODNjMi02MzI3M2QxZDA0ZGUiLCJ0eXAiOiJhdCtqd3QiLCJ" +
                "NZXJjaGFudElkIjoiNDAwMTY4NktBQjI0UDAxIiwiZXhwIjoxNzMxMzkwNzczLCJpc3MiOiJodHRwczovL2NvcmFscGF5LmNvb" +
                "SIsImF1ZCI6Imh0dHBzOi8vY29yYWxwYXkuY29tI" +
                "n0.jfKAuFzIPITeUpOwiZ9bs3G9wqh6khejAwfSFn5ztrTGXPEKmPVTm9hioTf-PIzPPSb8G1A5yU03JOZlpTopBg";
        return restClient
                .post()
                .uri("https://testdev.coralpay.com:5000/GwApi/api/v1/InvokePayment")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, value)
                .body(paymentRequest)
                .retrieve()
                .body(VergePaymentInvokePaymentResponse.class);

    }

    @Override
    public String generateSignature(String merchantId, String traceId, String timeStamp, String key) {


        String value = merchantId.concat(traceId).concat(timeStamp).concat(key);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(value.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch(NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash value not accepted");
        }
        // digest() method is called
        // to calculate message digest of the input string
        // returned as array of byte

    }

//    @Override
//    public String generateTraceId() {
//
//
//    }


}
