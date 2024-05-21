package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@NoArgsConstructor
public class FT9PSBAuthenticateRequest {

    private String publickey;
    private String privatekey;

}
