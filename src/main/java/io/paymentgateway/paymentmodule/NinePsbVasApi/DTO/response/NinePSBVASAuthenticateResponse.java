package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response;

import io.paymentgateway.paymentmodule.NinePsbVasApi.utils.VasData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinePSBVASAuthenticateResponse {

    private String status;
    private String responseCode;
    private String message;
    private VasData data;

}
