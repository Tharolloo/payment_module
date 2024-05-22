package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryToCreditReq {

    private String accountnumber;
    private String bankcode;
    private double feeamount;

}
