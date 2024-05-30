package io.paymentgateway.paymentmodule;

import io.micrometer.common.util.StringUtils;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.*;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.*;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.services.CoralPayCardPaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
public class CoralPayCardPaymentTest {

    @Autowired
    private CoralPayCardPaymentService service;

    @Autowired
    private static CoralCardRequest request;

    @Autowired
    private static CoralPayCardResponse response;

//    @Autowired
//    private VergePaymentInvokePaymentHeader requestHeader;

//    @Autowired
//    private VergeTransactionQueryRequest queryRequest;
//
//    @Autowired
//    private VergeTransactionQueryResponse queryResponse;



    @Autowired
    private static VergePaymentInvokePaymentRequest invokeRequest;

    @Autowired
    private static VergePaymentInvokePaymentResponse vergeresponse;

    @BeforeEach
    void setUp() {

        request = new CoralCardRequest();
        response = new CoralPayCardResponse();
       // this.requestHeader = new VergePaymentInvokePaymentHeader();
        vergeresponse = new VergePaymentInvokePaymentResponse();
        invokeRequest = new VergePaymentInvokePaymentRequest();

        request.setPassword("2CRGEI9T13DTG?DC!6PE0!E&&0I$N&QY6?#0I1AW");
        request.setUsername("labs@mM%eX*jSKSQAVBF)#np@)!N^PO");
        //request.setTerminalId("231167543AR2");
    }

    @AfterAll
    static void afterAll() {
        assertThat(request.getClass()).isNotNull();
    }

    @Test
    void checkCoralPayCardPaymentIsNotNull() {

        response = service.authenticate(request);

        log.info(response.toString());
        assertThat(response.getStatus()).isEqualTo("Success");

    }

    @Test
    void checkCoralPayVergePaymentIsNotNull() throws IllegalArgumentException {

        if(StringUtils.isNotEmpty(String.valueOf(invokeRequest))) {
            VergePaymentInvokePaymentHeader requestHeader = new VergePaymentInvokePaymentHeader();
            requestHeader.setMerchantId("4001686KAB24P01");
            requestHeader.setSignature("22b113804e26ecb95aabace34148e123187dc83599d4a471d1ed664e53662c45");
            requestHeader.setTimeStamp(1716990839);
            invokeRequest.setRequestHeader(requestHeader);

            log.info(invokeRequest.toString());

            // Customer Object specified in the JSON payload.
            VergeCustomer customer = new VergeCustomer();
            customer.setEmail("babavoss@see.com");
            customer.setName("Baba Voss");
            customer.setPhone("080300000001");
            customer.setTokenUserId("080300000001");

            invokeRequest.setCustomer(customer);

            //Customization Object specified.
            VergeCustomization customization = new VergeCustomization();
            customization.setDescription("Service Payment");
            customization.setTitle("Watermarks Limited");
            customization.setLogoUrl("http://sampleurl.com");

            invokeRequest.setCustomization(customization);

            //Meta Data Object in the JSON Payload
            MetaData metaData = new MetaData();

            metaData.setData1("sample data");
            metaData.setData2("another sample data");
            metaData.setData3("sample info");

            invokeRequest.setMetaData(metaData);

            invokeRequest.setTraceId("9099388491");
            invokeRequest.setProductId("aa12443d");
            invokeRequest.setCurrency("NGN");
            invokeRequest.setAmount(2000.00);
            invokeRequest.setFeeBearer("M");
            invokeRequest.setReturnUrl("http://samplereturnurl.com/status");

        } else {
            throw new NullPointerException("The value of the Invoke Payment is empty");
        }

        vergeresponse = service.invokePayment(invokeRequest);
        log.info(vergeresponse.toString());
        assertThat(vergeresponse.getTransactionId()).isEqualTo("48820240529095853369696");
    }

    @Test
    void checkSignature() {
        log.info(service.generateSignature("4001686KAB24P01","9900990285", "1716907733","0ab28984-ea4d-4929-8471-90232921131f"));

    }

    @Test
    void testTransactionQuery() {

        try {

            VergeTransactionQueryRequest queryRequest = new VergeTransactionQueryRequest();
            VergeTransactionQueryResponse queryResponse = new VergeTransactionQueryResponse();

            VergeTransactionQueryRequestHeader requestHeader = new VergeTransactionQueryRequestHeader();
            requestHeader.setMerchantId("4001686KAB24P01");
            requestHeader.setTimeStamp("1717074464");
            requestHeader.setSignature("ecd64924-2944-4500-b5e0-b63120d1810c");

            queryRequest.setTraceId("9099388491");

            queryRequest.setRequestHeader(requestHeader);

            //Refund refund = new Refund();

            queryResponse = service.query(queryRequest);

            assertThat(queryResponse.getResponseMessage()).isEqualTo("Success");
        } catch(Exception e) {
            e.getLocalizedMessage();
            throw new NullPointerException("Class file is empty");
        }

    }


}
