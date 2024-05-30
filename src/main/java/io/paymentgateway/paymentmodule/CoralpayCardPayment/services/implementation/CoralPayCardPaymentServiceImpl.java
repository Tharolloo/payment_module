package io.paymentgateway.paymentmodule.CoralpayCardPayment.services.implementation;

import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.CoralCardRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.VergePaymentInvokePaymentRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.VergeTransactionQueryRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.CoralPayCardResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.VergePaymentInvokePaymentResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.VergeTransactionQueryResponse;
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
    public VergeTransactionQueryResponse query(VergeTransactionQueryRequest queryRequest) {

        String credential = "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTUxMiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiI3MmNkZTc4Ni03ZWI5LTRhNGEtYWUwYS1hZmI0MmUzNmM2MDkiLCJ0eXAiOiJhdCtqd3QiLCJNZXJjaGFudElkIjoiNDAwMTY4NktBQjI0UDAxIiwiZXhwIjoxNzMxNDkxNzIxLCJpc3MiOiJodHRwczovL2NvcmFscGF5LmNvbSIsImF1ZCI6Imh0dHBzOi8vY29yYWxwYXkuY29tIn0.SD7kkv_SH1sxmNz3urBZts9Hhw-X-eMVzKbR0rq4irgwgs7lCk-AcEx8YqC_4REYy_6kOofy2ghmV5j0OWTvOg";        return restClient
                .post()
                .uri("https://testdev.coralpay.com:5000/GwApi/api/v1/TransactionQuery")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTUxMiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJhYzc5Mjk5Zi03YmIxLTRkODctOTg5Zi1jMjVmMTY2MmUzMTgiLCJ0eXAiOiJhdCtqd3QiLCJNZXJjaGFudElkIjoiNDAwMTY4NktBQjI0UDAxIiwiZXhwIjoxNzMxNDkyNDQ3LCJpc3MiOiJodHRwczovL2NvcmFscGF5LmNvbSIsImF1ZCI6Imh0dHBzOi8vY29yYWxwYXkuY29tIn0.4hQ3H6B7ZKVn8YuswBnjxLA-5xr-Jz65wqkFu_8xNhG5puG7jdo61D-dh2K7gjuYMf30wKIkGukzQIK8AVev7g")
                .body(queryRequest)
                .retrieve()
                .body(VergeTransactionQueryResponse.class);

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
