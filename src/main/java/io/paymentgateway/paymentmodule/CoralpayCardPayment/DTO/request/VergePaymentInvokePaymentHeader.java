package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VergePaymentInvokePaymentHeader {

    private String merchantId;
    private Integer timeStamp;
    private String signature;

}
