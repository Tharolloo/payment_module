package io.paymentgateway.paymentmodule.NinePSBWAAS.service;

import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.*;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.*;
import io.paymentgateway.paymentmodule.exceptions.PaymentServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class NinePSBWalletSeviceImpl implements NinePSBWalletService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private WebClient webClient;

    @Override
    public NinePSBAuthenticateResponse authenticate(NinePSBAuthenticateRequest authRequest) {

        return this.restClient.post()
                .uri("http://102.216.128.75:9090/bank9ja/api/v2/k1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(authRequest)
                .retrieve()
                .body(NinePSBAuthenticateResponse.class);
    }

    @Override
    public NinePSBOpenWalletResponse openWallet(NinePSBOpenWalletRequest openWalletRequest) {
        return null;
    }

    @Override
    public NinePSBWalletEnquiryResponse walletEnquiry(NinePSBWalletEnquiryRequest enquiryRequest) throws PaymentServiceException {

        return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/wallet_enquiry")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ enquiryRequest.getAccessToken())
                .body(enquiryRequest)
                .retrieve()
                .body(NinePSBWalletEnquiryResponse.class);
    }

    @Override
    public NinePSBSingleWalletResponse debit_transfer(NinePSBSingleWalletRequest singledebitRequest) throws PaymentServiceException {

        NinePSBSingleWalletResponse debit = this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/debit/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(singledebitRequest)
                .retrieve()
                .body(NinePSBSingleWalletResponse.class);

        return debit;
    }

    @Override
    public NinePSBSingleWalletResponse credit_transfer(NinePSBSingleWalletRequest singlecreditRequest) throws PaymentServiceException {

        return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/credit/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(singlecreditRequest)
                .retrieve()
                .body(NinePSBSingleWalletResponse.class);
    }

    @Override
    public NinePSBUpgradeStatusResponse upgrade_status(NinePSBUpgradeStatusRequest upgradeRequest) throws PaymentServiceException {

        return this.restClient
                .post()
                .uri("http://102.216.128.75:9090/waas/api/v1/upgrade_status")
                .body(upgradeRequest)
                .retrieve()
                .body(NinePSBUpgradeStatusResponse.class);
    }

}
