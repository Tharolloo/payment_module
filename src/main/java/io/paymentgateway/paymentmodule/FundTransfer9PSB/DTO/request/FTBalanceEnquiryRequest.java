package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.FTAccountRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FTBalanceEnquiryRequest {

    FTAccountRequest account;

}
