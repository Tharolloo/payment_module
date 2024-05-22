package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response;

import lombok.Data;

@Data
public class OrderResponse {

    private String amount;
    private String currency;
    private String description;
    private String country;
    private String amounttype;

}
