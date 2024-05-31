package io.paymentgateway.paymentmodule.NinePSBWAAS.service;

import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.*;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.*;
import io.paymentgateway.paymentmodule.exceptions.PaymentServiceException;

public interface NinePSBWalletService {

    NinePSBAuthenticateResponse authenticate(NinePSBAuthenticateRequest authRequest);


    NinePSBOpenWalletResponse openWallet(NinePSBOpenWalletRequest openWalletRequest);

    NinePSBWalletEnquiryResponse walletEnquiry(NinePSBWalletEnquiryRequest enquiryRequest);

    NinePSBSingleWalletResponse debit_transfer(NinePSBSingleWalletRequest walletRequest);

    NinePSBSingleWalletResponse credit_transfer(NinePSBSingleWalletRequest singlecreditRequest);

    NinePSBUpgradeStatusResponse  upgrade_status(NinePSBUpgradeStatusRequest upgradeRequest);

    NinePSBWalletUpgradeResponse wallet_upgrade(NinePSBWalletUpgradeRequest upgradeRequest);

}
