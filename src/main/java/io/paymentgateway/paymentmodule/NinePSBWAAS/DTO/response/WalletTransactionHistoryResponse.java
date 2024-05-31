package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WalletTransactionHistoryResponse {

    private String message;
    private String data;
    private String status;

}
