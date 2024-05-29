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

                return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/open_wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTY4OTUzNTcsImlhdCI6MTcxNjg4ODE1NywianRpIjoiMGQyMWFlMjQtZWNhNC00OTUxLTkxNzQtYjZhZmMzMDhiZDM0IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjI3ZWJhMGM5LTFkYzEtNDU4MS1iNjFjLTk1NWYwNzVmM2UwNyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiIyN2ViYTBjOS0xZGMxLTQ1ODEtYjYxYy05NTVmMDc1ZjNlMDciLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.nzp_hHpuTErjXnb5vctOi-3VzGQPrf5EU73FuQHcH1Ol_2iBtHdM-IUb8zn4Q3MYLT3wcwa7EB1XpHUBjbk0IlqFL91Tfw_-rlvYdWra6mnfCIM-h4Z3CWYh9SkJ_dRdjzOOfZwajzR0-Wxpfli24lNID-wM1kjHwwenlqPubhUMDl2vPzfdOVzlpOThpZtvcBq327xPHFUcUTpP3FL9RaOCEmPP6ORAQj1rp6bWOXapCOIuelCI3uP1CL6FYuJKACln-azBdrzLEddB31emRSshrSAK6veo7Tr1ItY5w9dfjeXbUQALeligJIaakcN31P1dNeWEuPA_fXJ3fxGgpg")
                .body(openWalletRequest)
                .retrieve()
                .body(NinePSBOpenWalletResponse.class);

    }

    @Override
    public NinePSBWalletEnquiryResponse walletEnquiry(NinePSBWalletEnquiryRequest enquiryRequest) throws PaymentServiceException {

        return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/wallet_enquiry")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTY4OTUzNTcsImlhdCI6MTcxNjg4ODE1NywianRpIjoiMGQyMWFlMjQtZWNhNC00OTUxLTkxNzQtYjZhZmMzMDhiZDM0IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjI3ZWJhMGM5LTFkYzEtNDU4MS1iNjFjLTk1NWYwNzVmM2UwNyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiIyN2ViYTBjOS0xZGMxLTQ1ODEtYjYxYy05NTVmMDc1ZjNlMDciLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.nzp_hHpuTErjXnb5vctOi-3VzGQPrf5EU73FuQHcH1Ol_2iBtHdM-IUb8zn4Q3MYLT3wcwa7EB1XpHUBjbk0IlqFL91Tfw_-rlvYdWra6mnfCIM-h4Z3CWYh9SkJ_dRdjzOOfZwajzR0-Wxpfli24lNID-wM1kjHwwenlqPubhUMDl2vPzfdOVzlpOThpZtvcBq327xPHFUcUTpP3FL9RaOCEmPP6ORAQj1rp6bWOXapCOIuelCI3uP1CL6FYuJKACln-azBdrzLEddB31emRSshrSAK6veo7Tr1ItY5w9dfjeXbUQALeligJIaakcN31P1dNeWEuPA_fXJ3fxGgpg")
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
