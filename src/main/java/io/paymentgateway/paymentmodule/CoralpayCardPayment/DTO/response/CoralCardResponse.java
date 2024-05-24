package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoralCardResponse {

    private String key;
    private String token;
    private String status;

}
