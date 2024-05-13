package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NinePSBVASAuthenticateRequest {

    private String username;
    private String password;

}
