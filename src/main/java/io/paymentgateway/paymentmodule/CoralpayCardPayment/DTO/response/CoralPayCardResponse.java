package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class CoralPayCardResponse {

    private String key;
    private String token;
    private String status;

}
