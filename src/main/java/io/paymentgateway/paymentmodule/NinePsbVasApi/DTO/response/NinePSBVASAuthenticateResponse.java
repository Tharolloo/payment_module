package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response;

import io.paymentgateway.paymentmodule.NinePsbVasApi.utils.VasData;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NinePSBVASAuthenticateResponse {

    private String status;
    private String responseCode;
    private String message;
    private VasData data;

}
