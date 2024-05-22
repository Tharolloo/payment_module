package io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualAuthenticationResponse {

    private String access_token;
    private String expires_in;
    private String code;
    private String message;

}
