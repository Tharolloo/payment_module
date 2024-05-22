package io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request;

import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request.BeneficiaryToCreditReq;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request.VirtualOrderRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request.TransactionRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request.VirtualCustomerReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicVirtualAccountRequest {

    TransactionRequest transaction;
    VirtualOrderRequest order;
    VirtualCustomerReq customer;
    BeneficiaryToCreditReq beneficiarytocredit;

}
