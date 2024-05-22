package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualOrderRequest {

    private double amount;
    private String currency;
    private String description;
    private String country;
    private String amounttype;

}
