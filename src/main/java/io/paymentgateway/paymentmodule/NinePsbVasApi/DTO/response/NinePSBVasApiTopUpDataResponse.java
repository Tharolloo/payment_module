package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response;

import io.paymentgateway.paymentmodule.NinePsbVasApi.utils.TopUpVasData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinePSBVasApiTopUpDataResponse {

    private String status;
    private String responseCode;
    private String message;
    private TopUpVasData data;

}
