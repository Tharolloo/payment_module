package io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoralPayCConnectAuthenticationReqest {

    private String Username;
    private String Password;

}
