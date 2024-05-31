package io.paymentgateway.paymentmodule.NinePSBWAAS.service;

import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.*;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.*;
import io.paymentgateway.paymentmodule.exceptions.PaymentServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface NinePSBWalletService {

    NinePSBAuthenticateResponse authenticate(NinePSBAuthenticateRequest authRequest);


    NinePSBOpenWalletResponse openWallet(NinePSBOpenWalletRequest openWalletRequest);

    NinePSBWalletEnquiryResponse walletEnquiry(NinePSBWalletEnquiryRequest enquiryRequest);

    NinePSBSingleWalletResponse debit_transfer(NinePSBSingleWalletRequest walletRequest);

    NinePSBSingleWalletResponse credit_transfer(NinePSBSingleWalletRequest singlecreditRequest);

    NinePSBUpgradeStatusResponse  upgrade_status(NinePSBUpgradeStatusRequest upgradeRequest);

    //NinePSBWalletUpgradeResponse wallet_upgrade(NinePSBWalletUpgradeRequest upgradeRequest);

    Function<String,String> fileExtension = null;

    BiFunction<String, MultipartFile, String> photoFunction = null;

    WalletTransactionHistoryResponse wallet_transaction(WalletTransactionHistoryRequest request);

}
