package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response;


import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.response.CustomerResponse;
import lombok.Data;

@Data
public class FTAccountEnquiryResponse {

    private CustomerResponse customer;
    private String code;
    private String message;

}
