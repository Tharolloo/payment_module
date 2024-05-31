package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NinePSBWalletUpgradeResponse {

    private String message;
    private String data;
    private String status;

}
