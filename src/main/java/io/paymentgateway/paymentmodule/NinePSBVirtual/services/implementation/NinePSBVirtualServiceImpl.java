package io.paymentgateway.paymentmodule.NinePSBVirtual.services.implementation;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FT9PSBAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request.DynamicVirtualAccountRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request.VirtualAuthenticationRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response.DynamicVirtualAccountResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response.VirtualAuthenticationResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.services.interfaces.NinePSBVirtualService;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.NinePSBAuthenticateResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@AllArgsConstructor
@Slf4j
@Service
public class NinePSBVirtualServiceImpl implements NinePSBVirtualService {

    private final RestClient restClient;
    @Override
    public VirtualAuthenticationResponse authenticate(VirtualAuthenticationRequest request) {

                return this.restClient
                .post()
                .uri("https://baastest.9psb.com.ng/iva-api/v1/merchant/virtualaccount/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                //.header(HttpHeaders.AUTHORIZATION, "Basic "+)
                .body(request)
                .retrieve()
                .body(VirtualAuthenticationResponse.class);

    }

    @Override
    public DynamicVirtualAccountResponse createDynamic(DynamicVirtualAccountRequest request) {

        String value = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJrZ0M0TXZES3ltWjlrZVBRQTFjWTAyVWdOODN3QTBUUG5YN3VDVlZEaVd1N055TVB0cEhROWlBK2FvYmVtYUNIcSt2bDdycjBqVEFsc1UvU05RV29KQ3N5WGEvcnVWVzNUUnlDcEpMdDJVVXp3YUpvV1FRL05FUkNwdnNUdW00S0ZTbDZZeWdVOHFCeUtTdm5wbThpUG9WbmQxY3g2Sk5xb2JDM3pqK2xQQ2s9IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvaGFzaCI6ImM3NjgxZGNhZmI5NzU0NjEyODQyZjc4M2RkZjEyOGJiYzk0ZjJlMTRkZmY4NGE4MWM1MmRjOTZkOWU0YTE5NDJiNTkxN2Y1OGFkYzFiZjk0NTE2MzdjZjg5NmUwNGVkMGQ5YmU2ZDQ5ZWQ3YWZkMmFjMGE3NzgyN2NhMWZiNmZiIiwicm9sZSI6IkhCWGRGaktaR1A2MGExRG1aYVI0OHVjWWlaazFkYVQ2TURiYVBuRVUzVUw1ZnlxQnZudWFxWUQ5TzR1N1lkRGtjUjFMajBQczExS1dOR1Y5cmJoeForSm5CeVhpcXlFN1NIazVvRklwV0lYUTFjelhoUkgrcVc4Qm9NeFl6S2hyZ2FtZXpTNllBd1EvWXp6RkhDOS9tMlRNME5xeXp3a28zdXVHLzJGN2hBSFc0V2RRMVF6by93ZElRYTJPK0ZhMEFHcDFQTTJ1YjcybjJKNk1WRnlwMEVrQkNWR2hhRzl5WDIzc2xKSm5OYVNKQ2tGNzlsYlIvYU9MdWRGbzhtL2NYQmo4YWQzTTVuRFdSS0lTNlhsblJpNnpkWkF1d1NVL0VkN1QvcUp3cUphNnBNTnBKMGx3aXk5YTQveUlhMFMxa2JKSlVTVzIxRVZ3VmJrZ3NyUGVwN29hcVJKeUlGMGVsdzZWa0lwV1VGRWtNYVJRblljWkliRkdlLzJOd1NiOFFaVEVpc1ZkYk15Y05OQitVaGNoSll2VzFOb0lvdlQ2V3FuZXBZSTA2MHl0dUFscXB3cU9GQXBrRXZFYkg4RXRxVWlYOGVmS0ZDcWRBcWNVeFRWWDh3PT0iLCJuYmYiOjE3MTYzODU5NDUsImV4cCI6MTcxNjM5MzE0NSwiaWF0IjoxNzE2Mzg1OTQ1LCJpc3MiOiI5UFNCX1NlcnZpY2VfSW50ZXJuYWwiLCJhdWQiOiI5UFNCX1NlcnZpY2VfSW50ZXJuYWwifQ.K8DFb6-6m0CyKW6QBj2uugrX30IwaJC11Am5MUvzUlojzpBLht1DQTz-cs3IBNb01KxFUPtRhuXiLGf5NUuFzg";
                return this.restClient
                .post()
                .uri("https://baastest.9psb.com.ng/iva-api/v1/merchant/virtualaccount/create")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, value)
                .body(request)
                .retrieve()
                .body(DynamicVirtualAccountResponse.class);

    }
}
