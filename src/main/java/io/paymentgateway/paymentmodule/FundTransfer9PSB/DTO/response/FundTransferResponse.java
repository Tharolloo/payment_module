package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.OrderReq;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response.CustomerResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class FundTransferResponse {

    private TransactionResponse transaction;
    private OrderReq order;
    private CustomerResponse customer;
    private String code;
    private String message;

}
