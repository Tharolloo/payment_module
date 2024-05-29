package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;

import lombok.Data;

@Data
public class VergePaymentInvokePaymentResponseHeader {

    private String responseCode;
    private String responseMessage;
    private String timeStamp;
    private String signature;

}
