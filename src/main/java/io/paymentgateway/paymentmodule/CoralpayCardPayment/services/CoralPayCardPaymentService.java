package io.paymentgateway.paymentmodule.CoralpayCardPayment.services;

import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.CoralCardRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.request.VergePaymentInvokePaymentRequest;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.CoralPayCardResponse;
import io.paymentgateway.paymentmodule.CoralpayCardPayment.DTO.response.VergePaymentInvokePaymentResponse;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface CoralPayCardPaymentService {

    CoralPayCardResponse authenticate(CoralCardRequest request);

    VergePaymentInvokePaymentResponse invokePayment(VergePaymentInvokePaymentRequest paymentRequest);

    String generateSignature(String merchantId, String traceId, String timeStamp, String key);

//    String generateTraceId();

}
