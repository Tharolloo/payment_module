package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.FTCustomerReq;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.OrderReq;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.TransactionReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferRequest {

    private TransactionReq transaction;
    private OrderReq order;
    private FTCustomerReq customer;
    private String hash;

}
