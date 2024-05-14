package io.paymentgateway.paymentmodule.NinePsbVasApi.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopUpVasData {

    private String recipient;
    private String network;
    private String amount;
    private String dataPlan;

}
