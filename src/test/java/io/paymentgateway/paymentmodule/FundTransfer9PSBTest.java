package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FT9PSBAuthenticateRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FTAccountEnquiryRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FTBalanceEnquiryRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FundTransferRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FT9PSBAuthenticateResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FTAccountEnquiryResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FundTransferResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.service.FT9PSBService;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@RequiredArgsConstructor
@SpringBootTest
public class FundTransfer9PSBTest {

    @Autowired
    private FT9PSBService service;

    @Test
    public void checkFTAuthenticateIsNotNull() {
        FT9PSBAuthenticateRequest authRequest = new FT9PSBAuthenticateRequest();
        authRequest.setPrivatekey("oNeUZA3yMHOCNZQP_VXrGPU6qTZppPGwrhQFgAEULat_Lh0fxme2cXPBdVSWEBCy");
        authRequest.setPublickey("F75CBA1ED5754C2590BAA68956831FF7");
        FT9PSBAuthenticateResponse response = service.authenticate(authRequest);
        log.info(response.getAccess_token());
        assertThat(response.getMessage()).isEqualTo("Success");

    }

    @Test
    void checkAccountEnquiry() {

        FTAccountEnquiryRequest enquiryRequest = new FTAccountEnquiryRequest();

        CustomerReq customerReq = new CustomerReq();

        FTAccountReq acct = new FTAccountReq();

        acct.setBank("120001");
        acct.setNumber("1100011255");

        customerReq.setAccount(acct);

        FTAccountEnquiryResponse resp = service.enquiry(enquiryRequest);
        log.info(resp.getMessage());
        assertThat(resp.getCustomer().getAccount().getNumber()).isEqualTo("1100011255");
        //assertThat(resp.getMessage()).isEqualTo("Invalid Credential");

    }

    @Test
    void checkToGenerateHashValue() {

        String privateKey = "oNeUZA3yMHOCNZQP_VXrGPU6qTZppPGwrhQFgAEULat_Lh0fxme2cXPBdVSWEBCy";
        String senderAccountNumber = "1100015371";
        String number = "1100000299";
        String bank = "120001";
        double amount = 2000.00;
        String reference = "VT20231228000000000000001";

        String hash = service.hashValue(privateKey,senderAccountNumber,number,bank,amount,reference);

        log.info(hash);
        assertThat(hash).isNotNull();
    }

    @Test
    void checkFundTransferIsNotNull() {

        FundTransferRequest fundTransferRequest = new FundTransferRequest();

        FTCustomerReq customer = new FTCustomerReq();
        FTAccountReq account = new FTAccountReq();
        TransactionReq transaction = new TransactionReq();

        // Transaction Object with Transaction Reference
        transaction.setReference("VT20231228000000000000001");

        //Account details with the customer value
        account.setBank("120001");
        account.setName("Merchant Name");
        account.setSenderaccountnumber("1100015371");
        account.setSendername("9PSB Agent/Oyenike Adeola");
        account.setNumber("1100000299");
        customer.setAccount(account);

        //Order value`
        OrderReq order = new OrderReq();

        order.setAmount(2000.00);
        order.setCurrency("NGN");
        order.setDescription("Virtual Settlement");
        order.setCountry("NGA");

        fundTransferRequest.setOrder(order);
        fundTransferRequest.setHash("c70b63145234f84842fca0492442f775ea0c0e5c764fed7083e1c4ddfa9b7eb618ce9618c42e7b2f3929a8065bc6062814c9905224df48cb081a7a9739f38605");
        fundTransferRequest.setCustomer(customer);
        fundTransferRequest.setTransaction(transaction);

        FundTransferResponse response = service.transfer(fundTransferRequest);

        assertThat(response).isNotEqualTo(null);
    }

    @Test
    void checkBalanceEnquiryForFundTransfer() {

        FTBalanceEnquiryRequest balance = new FTBalanceEnquiryRequest();



    }

}
