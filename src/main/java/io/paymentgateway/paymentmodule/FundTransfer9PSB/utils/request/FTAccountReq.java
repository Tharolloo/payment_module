package io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FTAccountReq {

    private String number;
    private String bank;
    private String name;
    private String senderaccountnumber;
    private String sendername;

}
