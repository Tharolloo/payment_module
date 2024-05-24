package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Vector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FTGetBankListResponse {

    private Vector<EachBankList> BankList = new Vector<EachBankList>();
    private String code;
    private String message;

}
