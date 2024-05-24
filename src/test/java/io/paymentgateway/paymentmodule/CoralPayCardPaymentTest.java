package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.CoralCardRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.CoralPayCardResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.services.CoralPayCardPaymentService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CoralPayCardPaymentTest {

    @Autowired
    private CoralPayCardPaymentService service;

    @Autowired
    private CoralCardRequest request;

    @Autowired
    private CoralPayCardResponse response;

    @BeforeEach
    void setUp() {

        this.request = new CoralCardRequest();
        this.response = new CoralPayCardResponse();

        request.setPassword("2213093821@010#3");
        request.setUsername("karrabo");
        request.setTerminalId("231167543AR2");
    }

    @AfterAll
    void afterAll() {
        assertThat(this.request.getClass()).isNotNull();
    }

    @Test
    void checkCoralPayCardPaymentIsNotNull() {

        this.response = service.authenticate(this.request);

    }
}
