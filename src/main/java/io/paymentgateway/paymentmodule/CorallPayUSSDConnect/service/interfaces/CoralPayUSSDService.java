package io.paymentgateway.paymentmodule.CorallPayUSSDConnect.service.interfaces;

import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.request.CoralPayCConnectAuthenticationReqest;
import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.response.CoralPayCConnectAuthenticationResponse;
import lombok.extern.slf4j.Slf4j;


public interface CoralPayUSSDService {

    String generateSignature(String merchantId, String terminalId, String timeStamp, String key);

    CoralPayCConnectAuthenticationResponse authenticate(CoralPayCConnectAuthenticationReqest authenticationReqest);
}
