package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;
import lombok.Data;

import java.util.List;

@Data
public class VergeTransactionQueryResponse {

    private String merchantId;
    private String terminalId;
    private String traceId;
    private String transactionId;
    private String paymentDate;
    //private String channel;
    private String amount;
    private String fee;
    private String feeBearer;
    private String title;
    private String description;
    private String paymentInstrument;
    private String timeStamp;
    private String signature;
    private String responseCode;
    private String responseMessage;
    private Channel channel;
    private List<Refund> refund;

}
