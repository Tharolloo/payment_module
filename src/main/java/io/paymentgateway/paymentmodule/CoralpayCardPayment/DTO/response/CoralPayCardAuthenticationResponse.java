package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CoralPayCardAuthenticationResponse {

    private String username;
    private String password;

}
