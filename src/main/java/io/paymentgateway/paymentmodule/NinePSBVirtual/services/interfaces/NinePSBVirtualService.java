package io.paymentgateway.paymentmodule.NinePSBVirtual.services.interfaces;

import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request.DynamicVirtualAccountRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.request.VirtualAuthenticationRequest;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response.DynamicVirtualAccountResponse;
import io.paymentgateway.paymentmodule.NinePSBVirtual.DTO.response.VirtualAuthenticationResponse;

public interface NinePSBVirtualService {

    VirtualAuthenticationResponse authenticate(VirtualAuthenticationRequest request);

    DynamicVirtualAccountResponse createDynamic(DynamicVirtualAccountRequest request);

    DynamicVirtualAccountResponse reallocate(DynamicVirtualAccountRequest request);
}
