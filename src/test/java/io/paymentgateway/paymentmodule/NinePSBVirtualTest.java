package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.TransactionReq;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request.DynamicVirtualAccountRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request.VirtualAuthenticationRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response.DynamicVirtualAccountResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response.VirtualAuthenticationResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.services.interfaces.NinePSBVirtualService;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.AccountType;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request.*;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response.Expiry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
public class NinePSBVirtualTest {

    @Autowired
    private NinePSBVirtualService virtualService;

//    @Autowired
//    private VirtualAuthenticationRequest authenticationRequest;

    @BeforeEach
    void setUp() {
    //authenticationRequest =


    }

    @Test
    public void checkToAuthenticate() {

        VirtualAuthenticationRequest authenticationRequest =  new VirtualAuthenticationRequest();

        authenticationRequest.setPrivatekey("9IWxL3OfOC4GO6JIQan4qlx9X8wBcz8YVjd1xizN_HR4gdlsrW0Mf7EUDQt5d1tC");
        authenticationRequest.setPublickey("195A1646D3274A6DBEB0CDC2C10CDE6A");

        VirtualAuthenticationResponse response = response = virtualService.authenticate(authenticationRequest);

        log.info(response.getAccess_token());

        assertThat(response.getAccess_token()).isNotNull();

    }

    @Test
    public void checkToCreateDynamicVirtualAccount() {

        DynamicVirtualAccountRequest request =  new DynamicVirtualAccountRequest();

        BeneficiaryToCreditReq beneficiaryToCredit = new BeneficiaryToCreditReq();
        beneficiaryToCredit.setAccountnumber("1100000299");
        beneficiaryToCredit.setBankcode("120001");
        beneficiaryToCredit.setFeeamount(3.75);

        request.setBeneficiarytocredit(beneficiaryToCredit);
        VirtualCustomerReq customer = new VirtualCustomerReq();
        VirtualAccountReq account = new VirtualAccountReq();
        account.setName("Amaechi Muonagor");
        account.setType(AccountType.DYNAMIC);

//        Expiry expiry = new Expiry();
//        expiry.setHours(1);
//        expiry.setDate("2023-06-11T13:47:31.7993952+01:00\"");
//        account.setExpiry(expiry);

        TransactionRequest transaction = new TransactionRequest();
        transaction.setReference("202307014083659123456102");

        request.setTransaction(transaction);

        customer.setNumber("5030000013");
        customer.setBank("9PSB");
        customer.setAccount(account);
        request.setCustomer(customer);

        VirtualOrderRequest order = new VirtualOrderRequest();

        order.setCountry("NGA");
        order.setDescription("Test TRF");
        order.setAmount(350);
        order.setCurrency("NGN");
        order.setAmounttype("ANY");

        request.setOrder(order);

        DynamicVirtualAccountResponse response = virtualService.createDynamic(request);

        assertThat(response.toString()).isNotNull();
        assertThat(response.getMessage()).isEqualTo("success");
    }

    @Test
    public void checkToCreateStaticVirtualAccount() {

        DynamicVirtualAccountRequest request =  new DynamicVirtualAccountRequest();

        BeneficiaryToCreditReq beneficiaryToCredit = new BeneficiaryToCreditReq();
        beneficiaryToCredit.setAccountnumber("1100000299");
        beneficiaryToCredit.setBankcode("120001");
        beneficiaryToCredit.setFeeamount(3.75);

        request.setBeneficiarytocredit(beneficiaryToCredit);
        VirtualCustomerReq customer = new VirtualCustomerReq();
        VirtualAccountReq account = new VirtualAccountReq();
        account.setName("Amaechi Muonagor");
        account.setType(AccountType.STATIC);

//        Expiry expiry = new Expiry();
//        expiry.setHours(1);
//        expiry.setDate("2023-06-11T13:47:31.7993952+01:00\"");
//        account.setExpiry(expiry);

        TransactionRequest transaction = new TransactionRequest();
        transaction.setReference("202307014083659123456109");

        request.setTransaction(transaction);

        customer.setNumber("5030000013");
        customer.setBank("9PSB");
        customer.setAccount(account);
        request.setCustomer(customer);

        VirtualOrderRequest order = new VirtualOrderRequest();

        order.setCountry("NGA");
        order.setDescription("Test TRF");
        order.setAmount(350);
        order.setCurrency("NGN");
        order.setAmounttype("ANY");

        request.setOrder(order);

        DynamicVirtualAccountResponse response = virtualService.createDynamic(request);

        assertThat(response.toString()).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Success");
    }

    @Test
    public void checkToReallocateVirtualAccount() {

        DynamicVirtualAccountRequest request =  new DynamicVirtualAccountRequest();

        BeneficiaryToCreditReq beneficiaryToCredit = new BeneficiaryToCreditReq();
        beneficiaryToCredit.setAccountnumber("1100000299");
        beneficiaryToCredit.setBankcode("120001");
        beneficiaryToCredit.setFeeamount(3.75);

        request.setBeneficiarytocredit(beneficiaryToCredit);
        VirtualCustomerReq customer = new VirtualCustomerReq();
        VirtualAccountReq account = new VirtualAccountReq();
        account.setName("Amaechi Muonagor");
        account.setType(AccountType.DYNAMIC);

        Expiry expiry = new Expiry();
        expiry.setHours(1);
//        expiry.setDate("2023-06-11T13:47:31.7993952+01:00\"");
        account.setExpiry(expiry);

        TransactionRequest transaction = new TransactionRequest();
        transaction.setReference("202307014083659123456107");

        request.setTransaction(transaction);

        customer.setNumber("5030000013");
        customer.setBank("9PSB");
        customer.setAccount(account);
        request.setCustomer(customer);

        VirtualOrderRequest order = new VirtualOrderRequest();

        order.setCountry("NGA");
        order.setDescription("Test TRF");
        order.setAmount(350);
        order.setCurrency("NGN");
        order.setAmounttype("ANY");

        request.setOrder(order);

        DynamicVirtualAccountResponse response = virtualService.reallocate(request);

        assertThat(response.toString()).isNotNull();
        assertThat(response.getMessage()).isEqualTo("success");
    }



}
