package io.paymentgateway.paymentmodule.NinePsbVasApi.services;


import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;

public interface NinePSBVasApiService {

    NinePSBVASAuthenticateResponse authenticate(NinePSBVASAuthenticateRequest request);

}
