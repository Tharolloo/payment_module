package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;
import lombok.Data;

@Data
public class Refunds {

    private String refundId;
    private String amount;
    private String channel;
    private String traceId;
    private String transactionId;
    private String refundDate;

}
