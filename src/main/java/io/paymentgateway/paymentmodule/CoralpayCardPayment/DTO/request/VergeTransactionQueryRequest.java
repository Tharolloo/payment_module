package io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VergeTransactionQueryRequest {

   private VergeTransactionQueryRequestHeader requestHeader;
   private String traceId;

}
