package io.paymentgateway.paymentmodule.CoralpayCardPayment.services;

import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.CoralCardRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.CoralPayCardResponse;

public interface CoralPayCardPaymentService {

    CoralPayCardResponse authenticate(CoralCardRequest request);



}
