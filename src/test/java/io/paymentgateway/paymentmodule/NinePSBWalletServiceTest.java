package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.NinePSBAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.NinePSBSingleWalletRequest;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.NinePSBUpgradeStatusRequest;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.NinePSBWalletEnquiryRequest;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.NinePSBAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.NinePSBSingleWalletResponse;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.NinePSBUpgradeStatusResponse;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.NinePSBWalletEnquiryResponse;
import io.paymentgateway.paymentmodule.NinePSBWAAS.service.NinePSBWalletService;
import io.paymentgateway.paymentmodule.NinePSBWAAS.utils.Merchant;
import io.paymentgateway.paymentmodule.NinePSBWAAS.utils.TransactionType;
import io.paymentgateway.paymentmodule.exceptions.PaymentServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class NinePSBWalletServiceTest {

    @Autowired
    private NinePSBWalletService ninePSBWalletService;

//    @Autowired
//    private  enqrequest;

    private NinePSBSingleWalletRequest singleRequest = new NinePSBSingleWalletRequest();


    private NinePSBUpgradeStatusRequest upgradeStatus;


    @BeforeEach
    void SetUp() {

    }

    @Test
    void checkNinePSBAuthenticationWithNullRequest() throws PaymentServiceException {

       // assertEquals(null, ninePSBWalletService.authenticate(null));
        assertThrows(PaymentServiceException.class, () -> ninePSBWalletService.authenticate(null));
    }

    @Test
    void checkNinePSBAuthenticationWithEmptyRequest() throws PaymentServiceException {
        NinePSBAuthenticateRequest request = new NinePSBAuthenticateRequest();

        request.setClientId("waas");
        request.setClientSecret("cRAwnWElcNMUZpALdnlve6PubUkCPOQR");
        request.setUsername("karrabo");
        request.setPassword("ttwckoHfaNXIuEZEQbTx1shOz3lHHswTgoQEakkOAr5Te7L1HB");

        NinePSBAuthenticateResponse resp = ninePSBWalletService.authenticate(request);
        //assertThrows(PaymentServiceException.class, () -> ninePSBWalletService.authenticate(request));
        assertEquals("h", resp.getAccessToken());
    }

//    @Test
//    void checkNinePSBAuthenticationWithRealObject() {
//
//        NinePSBAuthenticateRequest req = new NinePSBAuthenticateRequest();
//
//
//
//    }

    @Test
    void checkOpenWalletWithNullRequest(){
        assertThrows(PaymentServiceException.class, () -> ninePSBWalletService.openWallet(null));
    }

    @Test
    void confirmWalletAccountIsValid() throws PaymentServiceException {
        NinePSBWalletEnquiryRequest enqrequest = new NinePSBWalletEnquiryRequest();
        enqrequest.setAccountNo("1100014518");
        enqrequest.setAccessToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTUzNTQ0MzQsImlhdCI6MTcxNTM0NzIzNCwianRpIjoiZmVkNmIyYmItMzRmYS00YzlhLWExMzMtYjBmMWIzZTNkYjA3IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjdjMDgxMTVjLWNhZGQtNGEyNS1iMDhhLTE2ZTI0ZTA2MzExYyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI3YzA4MTE1Yy1jYWRkLTRhMjUtYjA4YS0xNmUyNGUwNjMxMWMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.fwuPuFZrF-refG1z7UI5NfsuTNe_85wchOq7pv6tELV2w9hT07O3NyCf3lB2Ycy_z-c1vbb-sk66tGh3E950N2TgGTGC9T6ELUDUU0tOo4u_AMqUMq9A5mKIorbT6oeuJxaToL2KYMncZPMhmHwQF0dn3MwH6yLgjdTqlexFrds4s4nEkIem6rCeljAH79WgrCwEO37I4R03ZuJrLYwlI6WC6skc5-3bYfylNHM-XEmgh1Sp2En5tIhnKAeiSrS1LoVurcZCMgAINI4z2CsliDPvH00sE-cj_gy3J_L1perE1x3BOkDAQcRWqRvRiUE5NNm2EjExu_5ga5Iu_V4Wiw");
        NinePSBWalletEnquiryResponse resp = ninePSBWalletService.walletEnquiry(enqrequest);
        assertNotNull(resp);
    }

    @Test
    void confirmSingleDebitWalletIsNotNull() throws PaymentServiceException {
        Merchant merchant = new Merchant("","",false);
        this.singleRequest = new NinePSBSingleWalletRequest();
        singleRequest.setMerchant(merchant);
        singleRequest.setAccountNo("1100025756");
        singleRequest.setNarration("MERCHANT_NAME/CREDIT_WALLET/1100025718/WAAS202511202217112977");
        singleRequest.setTransactionType(TransactionType.DEBIT_WALLET);
        singleRequest.setTransactionId("WAAS202511202217112977");
        singleRequest.setTotalAmount(1000.00);

        NinePSBSingleWalletResponse ninePSBSingleWalletResponse = ninePSBWalletService.debit_transfer(singleRequest);
        assertFalse(singleRequest.getMerchant().isFee());
        assertNotNull(singleRequest);
        assertNotNull(ninePSBSingleWalletResponse.getStatus());
        assertEquals("FAILED",ninePSBSingleWalletResponse.getStatus());
        assertEquals("SUCCESS", ninePSBSingleWalletResponse.getMessage());
    }

    @Test
    void confirmSingleCreditWalletIsNotNull() throws PaymentServiceException {
        Merchant merchant = new Merchant("","",false);
        this.singleRequest = new NinePSBSingleWalletRequest();
        singleRequest.setMerchant(merchant);
        singleRequest.setAccountNo("1100025756");
        singleRequest.setNarration("MERCHANT_NAME/CREDIT_WALLET/1100025718/WAAS202511202217112977");
        singleRequest.setTransactionType(TransactionType.CREDIT_WALLET);
        singleRequest.setTransactionId("WAAS202511202217112977");
        singleRequest.setTotalAmount(1000.00);
        NinePSBSingleWalletResponse ninePSBSingleWalletResponse = ninePSBWalletService.credit_transfer(singleRequest);

        assertFalse(singleRequest.getMerchant().isFee());
        assertNotNull(singleRequest);
        assertNotNull(ninePSBSingleWalletResponse.getStatus());
        assertEquals("FAILED",ninePSBSingleWalletResponse.getStatus());
        assertEquals("SUCCESS", ninePSBSingleWalletResponse.getMessage());
        assertNotNull(singleRequest);
    }

    @Test
    void checkUpgradeStatusIsNotNull() throws PaymentServiceException {

        this.upgradeStatus = new NinePSBUpgradeStatusRequest("1100015300");

        NinePSBUpgradeStatusResponse resp = ninePSBWalletService.upgrade_status(upgradeStatus);

        assertNotNull(resp);
        assertEquals("SUCCESS", resp.getMessage());
        assertEquals("FAILED", resp.getStatus());

    }



}
