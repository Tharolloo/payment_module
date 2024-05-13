package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletEnquiryData {

    private String responseMessage;
    private String productCode;
    private String email;
    private String firstName;
    private String lastName;
    private String lienStatus;
    private String bvn;
    private Double availableBalance;
    private String freezeStatus;
    private Double ledgerBalance;
    private Double maximumBalance;
    private String nuban;
    private String number;
    private String phoneNo;
    private String phoneNumber;
    private String maximumDeposit;
    private String pndstatus;
    private String tier;
    private String responseDescription;
    private String responseCode;
    private String responseStatus;
    private Boolean isSuccessful;
    private String status;
    private String name;

}
