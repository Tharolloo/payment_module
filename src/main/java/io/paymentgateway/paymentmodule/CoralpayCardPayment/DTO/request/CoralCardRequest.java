package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoralCardRequest {

    private String username;
    private String password;
    private String terminalId;

}
