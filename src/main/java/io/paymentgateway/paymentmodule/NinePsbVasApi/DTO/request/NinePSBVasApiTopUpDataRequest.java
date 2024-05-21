package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class NinePSBVasApiTopUpDataRequest {

        private String phoneNumber;
        private String network;
        private String productId;
        private String amount;
        private String debitAmount;
        private String transactionReference;

    }
