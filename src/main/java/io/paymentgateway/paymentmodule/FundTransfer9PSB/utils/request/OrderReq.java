package io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReq {

    private double amount;
    private String description;
    private String currency;
    private String country;

}
