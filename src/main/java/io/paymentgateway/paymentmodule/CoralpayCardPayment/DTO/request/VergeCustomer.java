package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request;

import lombok.Data;

@Data
public class VergeCustomer {

    private String email;
    private String name;
    private String phone;
    private String tokenUserId;

}
