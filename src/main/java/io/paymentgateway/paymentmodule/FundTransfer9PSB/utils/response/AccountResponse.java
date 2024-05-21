package io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response;

import lombok.Data;

@Data
public class AccountResponse {

    private String number;
    private String bank;
    private String name;
    private String bvn;
    private String senderaccountnumber;
    private String kyc;

}
