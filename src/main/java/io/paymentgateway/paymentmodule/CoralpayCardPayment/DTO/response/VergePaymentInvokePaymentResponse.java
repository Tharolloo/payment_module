package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;

import lombok.Data;

@Data
public class VergePaymentInvokePaymentResponse {

    private VergePaymentInvokePaymentResponseHeader responseHeader;
    private String transactionId;
    private String traceId;
    private String payPageLink;
    private String metaData;

}
