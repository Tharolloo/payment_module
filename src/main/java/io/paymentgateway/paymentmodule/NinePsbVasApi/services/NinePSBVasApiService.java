package io.paymentgateway.paymentmodule.NinePsbVasApi.services;


import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVasApiAirtimeTopUpRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVasApiAirtimeTopUpResponse;

public interface NinePSBVasApiService {

    NinePSBVASAuthenticateResponse authenticate(NinePSBVASAuthenticateRequest request);

    NinePSBVasApiAirtimeTopUpResponse topUp(NinePSBVasApiAirtimeTopUpRequest request);

}
