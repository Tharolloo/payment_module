package io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualAuthenticationRequest {

    private String publickey;
    private String privatekey;

}
