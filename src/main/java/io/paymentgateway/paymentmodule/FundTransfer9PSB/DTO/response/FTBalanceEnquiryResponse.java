package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response.FTBAccountResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FTBalanceEnquiryResponse {

    private FTBAccountResponse account;
    private String code;
    private String message;

}
