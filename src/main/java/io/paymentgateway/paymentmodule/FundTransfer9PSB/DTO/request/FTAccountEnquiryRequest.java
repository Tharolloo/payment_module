package io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request;


import io.paymentgateway.paymentmodule.FundTransfer9PSB.utils.request.CustomerReq;
import lombok.Data;

@Data
public class FTAccountEnquiryRequest {

    private CustomerReq customer;

}
