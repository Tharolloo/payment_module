package io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinePSBVasApiAirtimeTopUpRequest {

    private String phoneNumber;
      private String network;
      private String amount;
      private String debitAccount;
      private String transactionReference;

}
