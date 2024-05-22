package io.paymentgateway.paymentmodule.NinePSBVirtual.utils.request;

import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.AccountType;
import io.paymentgateway.paymentmodule.NinePSBVirtual.utils.response.Expiry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualAccountReq {

    private String name;
    private String type;
    //private Expiry expiry;

}
