package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class VergePaymentInvokePaymentRequest {

    private VergePaymentInvokePaymentHeader requestHeader;
    private VergeCustomer customer;

    private VergeCustomization customization;

    private MetaData metaData;
    private String traceId;
    private String productId;
    private Double amount;
    private String currency;
    private String feeBearer;
    private String returnUrl;

}
