package io.paymentgateway.paymentmodule.FundTransfer9PSB.service;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.*;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.*;

public interface FT9PSBService {

    FT9PSBAuthenticateResponse authenticate(FT9PSBAuthenticateRequest request);

    FTAccountEnquiryResponse enquiry(FTAccountEnquiryRequest request);

    FundTransferResponse transfer(FundTransferRequest request);

    String hashValue(String token, String senderaccountnumber,String accountnumber, String bank, double amount, String reference);

    FTBalanceEnquiryResponse balance(FTBalanceEnquiryRequest request);

    FTGetBankListResponse getbanks(FTGetBankListReq listReq);
}
