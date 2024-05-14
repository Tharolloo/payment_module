package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinePSBVASAuthenticateRequest {

    private String username;
    private String password;

}
