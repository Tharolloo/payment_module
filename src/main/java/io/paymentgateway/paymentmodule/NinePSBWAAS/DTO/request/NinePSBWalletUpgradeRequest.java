package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.awt.*;

@Data
@RequiredArgsConstructor
@Builder
public class NinePSBWalletUpgradeRequest {

    private String accountNumber;
    private String bvn;
    private String accountName;
    private  String phoneNumber;
    private String tier;
    private String email;
    private String userPhoto;
    private String idType;
    private String idNumber;
    private String idIssueDate;
    private String idExpiryDate;
    private String idCardFront;
    private String idCardBack;
    private String houseNumber;
    private String streetName;
    private String state;
    private String city;
    private String localGovernment;
    private String pep;
    private String customerSignature;
    private String utilityBill;
    private String nearestLandMark;
    private String placeOfBirth;
    private String proofOfAddressVerification;

}
