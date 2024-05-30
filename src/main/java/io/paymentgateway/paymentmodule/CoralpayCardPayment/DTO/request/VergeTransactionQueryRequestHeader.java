package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request;
import lombok.Data;

@Data
public class VergeTransactionQueryRequestHeader {

    private String merchantId;
    private String timeStamp;
    private String signature;

}
