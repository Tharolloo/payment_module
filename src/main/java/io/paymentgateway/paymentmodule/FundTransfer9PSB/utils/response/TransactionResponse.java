package io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class TransactionResponse {

    private String reference;
    private String linkingreference;
    private String externalreference;
    private String date;

}
