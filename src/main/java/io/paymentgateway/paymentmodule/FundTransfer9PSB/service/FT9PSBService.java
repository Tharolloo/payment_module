package io.paymentgateway.paymentmodule.FundTransfer9PSB.service;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FT9PSBAuthenticateRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FTAccountEnquiryRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FTBalanceEnquiryRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FundTransferRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FT9PSBAuthenticateResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FTAccountEnquiryResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FTBalanceEnquiryResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FundTransferResponse;

public interface FT9PSBService {

    FT9PSBAuthenticateResponse authenticate(FT9PSBAuthenticateRequest request);

    FTAccountEnquiryResponse enquiry(FTAccountEnquiryRequest request);

    FundTransferResponse transfer(FundTransferRequest request);

    String hashValue(String token, String senderaccountnumber,String accountnumber, String bank, double amount, String reference);

    FTBalanceEnquiryResponse balance(FTBalanceEnquiryRequest request);
}
