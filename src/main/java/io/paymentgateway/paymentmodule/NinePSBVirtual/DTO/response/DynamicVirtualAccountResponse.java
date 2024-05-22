package io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response;

import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response.BeneficiaryToCreditResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response.CustomerResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response.OrderResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DynamicVirtualAccountResponse {

    private String code;
    private String message;
    private TransactionResponse transaction;
    private OrderResponse order;
    private CustomerResponse customer;
    private BeneficiaryToCreditResponse beneficiarytocredit;

}
