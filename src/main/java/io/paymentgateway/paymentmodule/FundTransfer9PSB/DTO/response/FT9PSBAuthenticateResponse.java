package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FT9PSBAuthenticateResponse {

    private String access_token;
    private String expires_in;
    private String code;
    private String message;

}
