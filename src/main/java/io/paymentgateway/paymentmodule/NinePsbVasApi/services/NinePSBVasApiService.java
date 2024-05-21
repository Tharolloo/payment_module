package io.paymentgateway.paymentmodule.NinePsbVasApi.services;


import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVasApiAirtimeTopUpRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVasApiTopUpDataRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVasApiAirtimeTopUpResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVasApiTopUpDataResponse;

public interface NinePSBVasApiService {

    NinePSBVASAuthenticateResponse authenticate(NinePSBVASAuthenticateRequest request);

    NinePSBVasApiAirtimeTopUpResponse topUp(NinePSBVasApiAirtimeTopUpRequest request);

    NinePSBVasApiTopUpDataResponse topUpData(NinePSBVasApiTopUpDataRequest dataRequest);
}
