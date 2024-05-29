package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request;

import lombok.Data;

@Data
public class NinePSBOpenWalletRequest {

    private String transactionTrackingRef;
    private String lastName;
    private String otherNames;
    private String accountName;
    private String phoneNo;
    private int gender;
    private String dateOfBirth;
    private String email;
    private String bvn;
    private String customerID;
    private String walletType;

}
