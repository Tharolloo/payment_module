package io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FTBAccountResponse {

    private String accountnumber;
    private double accountbalance;
    private double ledgerbalance;
    private double minimumbalance;

}
