package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private String reference;
}
