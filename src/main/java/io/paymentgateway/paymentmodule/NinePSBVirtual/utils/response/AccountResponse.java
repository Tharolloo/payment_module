package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response;

import lombok.Data;

@Data
public class AccountResponse {

    private String name;
    private String type;
    private Expiry expiry;
    private String number;
    private String bank;

}
