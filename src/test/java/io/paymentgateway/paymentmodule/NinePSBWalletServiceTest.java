package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.*;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.*;
import io.paymentgateway.paymentmodule.NinePSBWAAS.service.NinePSBWalletService;
import io.paymentgateway.paymentmodule.NinePSBWAAS.utils.Merchant;
import io.paymentgateway.paymentmodule.NinePSBWAAS.utils.TransactionType;
import io.paymentgateway.paymentmodule.exceptions.PaymentServiceException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static io.paymentgateway.paymentmodule.NinePSBWAAS.service.NinePSBWalletService.photoFunction;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@Builder
@SpringBootTest
public class NinePSBWalletServiceTest {

    @Autowired
    private NinePSBWalletService ninePSBWalletService;

//    @Autowired
//    private  enqrequest;
//    @Autowired
//    private ModelMapper mapper;


    private NinePSBUpgradeStatusRequest upgradeStatus;


    @BeforeEach
    void SetUp() {

    }

    @Test
    void checkNinePSBAuthenticationWithNullRequest() throws PaymentServiceException, NullPointerException {
        NinePSBAuthenticateRequest request = new NinePSBAuthenticateRequest();
        // assertEquals(null, ninePSBWalletService.authenticate(null));
        assertThrows(PaymentServiceException.class, () -> ninePSBWalletService.authenticate(request));
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
    void checkOpenWalletWithNullRequest() {
        assertThrows(PaymentServiceException.class, () -> ninePSBWalletService.openWallet(null));
    }

    @Test
    void confirmWalletAccountIsValid() {
        NinePSBWalletEnquiryRequest enqrequest = new NinePSBWalletEnquiryRequest();
        enqrequest.setAccountNo("1100014518");
        enqrequest.setAccessToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTY4OTUzNTcsImlhdCI6MTcxNjg4ODE1NywianRpIjoiMGQyMWFlMjQtZWNhNC00OTUxLTkxNzQtYjZhZmMzMDhiZDM0IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjI3ZWJhMGM5LTFkYzEtNDU4MS1iNjFjLTk1NWYwNzVmM2UwNyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiIyN2ViYTBjOS0xZGMxLTQ1ODEtYjYxYy05NTVmMDc1ZjNlMDciLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.nzp_hHpuTErjXnb5vctOi-3VzGQPrf5EU73FuQHcH1Ol_2iBtHdM-IUb8zn4Q3MYLT3wcwa7EB1XpHUBjbk0IlqFL91Tfw_-rlvYdWra6mnfCIM-h4Z3CWYh9SkJ_dRdjzOOfZwajzR0-Wxpfli24lNID-wM1kjHwwenlqPubhUMDl2vPzfdOVzlpOThpZtvcBq327xPHFUcUTpP3FL9RaOCEmPP6ORAQj1rp6bWOXapCOIuelCI3uP1CL6FYuJKACln-azBdrzLEddB31emRSshrSAK6veo7Tr1ItY5w9dfjeXbUQALeligJIaakcN31P1dNeWEuPA_fXJ3fxGgpg");
        NinePSBWalletEnquiryResponse resp = ninePSBWalletService.walletEnquiry(enqrequest);
        assertThat(resp.getMessage()).isEqualTo("Success");
    }

    @Test
    void confirmSingleDebitWalletIsNotNull() {

        Merchant merchant = new Merchant("", "", false);
        NinePSBSingleWalletRequest singleRequest = new NinePSBSingleWalletRequest();
        singleRequest.setMerchant(merchant);
        singleRequest.setAccountNo("1100025756");
        singleRequest.setNarration("MERCHANT_NAME/DEBIT_WALLET/1111111111/WAAS2025112022179938");
        singleRequest.setTransactionType("DEBIT_WALLET");
        singleRequest.setTransactionId("WAAS2025112022179938");
        singleRequest.setTotalAmount(1000.00);

        NinePSBSingleWalletResponse ninePSBSingleWalletResponse = ninePSBWalletService.debit_transfer(singleRequest);
        System.out.println(" response -------->>> " + ninePSBSingleWalletResponse);
        assertFalse(singleRequest.getMerchant().isFee());
        assertNotNull(singleRequest);
        assertNotNull(ninePSBSingleWalletResponse.getStatus());
        assertEquals("FAILED", ninePSBSingleWalletResponse.getStatus());
        assertEquals(ninePSBSingleWalletResponse.getMessage(), "Duplicate transaction reference");

    }

    @Test
    void confirmSingleCreditWalletIsNotNull() {
        Merchant merchant = new Merchant("", "", false);
        NinePSBSingleWalletRequest singleRequest = new NinePSBSingleWalletRequest();
        singleRequest.setMerchant(merchant);
        singleRequest.setAccountNo("1100025756");
        singleRequest.setNarration("");
        singleRequest.setTransactionType("CREDIT_WALLET");
        singleRequest.setTransactionId("WAAS202511202217112977");
        singleRequest.setTotalAmount(1000.00);
        NinePSBSingleWalletResponse ninePSBSingleWalletResponse = ninePSBWalletService.credit_transfer(singleRequest);

        assertFalse(singleRequest.getMerchant().isFee());
        assertNotNull(singleRequest);
        assertNotNull(ninePSBSingleWalletResponse.getStatus());
        assertEquals("FAILED", ninePSBSingleWalletResponse.getStatus());
        assertEquals("SUCCESS", ninePSBSingleWalletResponse.getMessage());
        assertNotNull(singleRequest);
    }

    @Test
    void checkUpgradeStatusIsNotNull() {

        this.upgradeStatus = new NinePSBUpgradeStatusRequest("1100025756");

        NinePSBUpgradeStatusResponse resp = ninePSBWalletService.upgrade_status(upgradeStatus);

        assertNotNull(resp);
        assertEquals("No record found", resp.getMessage());
        assertEquals("Failed", resp.getStatus());

    }

    @Test
    void isOpenNewWalletValid() {

        NinePSBOpenWalletRequest request = new NinePSBOpenWalletRequest();

        request.setBvn("22237913104");
        request.setWalletType("INDIVIDUAL");
        request.setGender(0);
        request.setEmail("awoseemobabajide@gmail.com");
        request.setAccountName("Awoseemo Babajide Akinlolu");
        request.setLastName("Akinlolu");
        request.setPhoneNo("07069160721");
        request.setTransactionTrackingRef("mytestapi");
        request.setDateOfBirth("30/01/1993");
        request.setOtherNames("Babajide");
        request.setCustomerID("");

        NinePSBOpenWalletResponse response = ninePSBWalletService.openWallet(request);

        assertThat(response.getMessage()).isEqualTo("successful");

    }

//    @Test
//    void confirmWalletUpgradeIsNotNull() {
//
//        // NinePSBWalletUpgradeResponse response = new NinePSBWalletUpgradeResponse();
//        NinePSBWalletUpgradeRequest request = new NinePSBWalletUpgradeRequest();
//
//        String photoUrl = photoFunction.apply();
//
//
//    }

//    public String uploadPhoto(String id, MultipartFile file){
//        String photoUrl = photoFunction.apply(id, file);
//        NinePSBWalletUpgradeRequest request = new NinePSBWalletUpgradeRequest();
//        request.setUserPhoto(photoUrl);
//        return photoUrl;
//    }

    @Test
    void checkWalletTransactionHistory() {

        WalletTransactionHistoryRequest request = WalletTransactionHistoryRequest
                .builder()
                .accountNumber("1100025756")
                .fromDate("2024-01-02")
                .toDate("2024-02-02")
                .build();

        WalletTransactionHistoryResponse response = ninePSBWalletService



    }
}
