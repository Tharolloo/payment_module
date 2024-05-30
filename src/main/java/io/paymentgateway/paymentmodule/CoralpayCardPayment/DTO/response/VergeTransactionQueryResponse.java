package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class VergeTransactionQueryResponse {

    private String merchantId;
    private String paymentDate;
    private String traceId;
    private String terminalId;
    private String transactionId;
    private String channel;
    //private String channel;
    private String amount;
    private String fee;
    private String feeBearer;
    private String title;
    private String description;
    private String paymentInstrument;
    private Integer timeStamp;
    private String signature;
    private String responseCode;
    private String responseMessage;
    private String channelTransactionId;
    private List<Refunds> refunds;

}
