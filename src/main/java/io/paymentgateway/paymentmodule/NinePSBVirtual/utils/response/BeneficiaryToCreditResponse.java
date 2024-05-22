package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response;

import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request.BeneficiaryToCreditReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryToCreditResponse extends BeneficiaryToCreditReq {

    private double feeamount;

}
