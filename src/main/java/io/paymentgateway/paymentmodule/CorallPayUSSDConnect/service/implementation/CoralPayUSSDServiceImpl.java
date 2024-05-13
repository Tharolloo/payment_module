package io.paymentgateway.paymentmodule.CorallPayUSSDConnect.service.implementation;


import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.request.CoralPayCConnectAuthenticationReqest;
import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.response.CoralPayCConnectAuthenticationResponse;
import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.service.interfaces.CoralPayUSSDService;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.NinePSBAuthenticateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Service
@Slf4j
public class CoralPayUSSDServiceImpl implements CoralPayUSSDService {

    @Autowired
    private RestClient restClient;

    @Override
    public String generateSignature(String merchantId, String terminalId, String timeStamp, String key) {

        String value = merchantId.concat(terminalId).concat(timeStamp).concat(key);

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] messageDigest = md.digest(value.getBytes());

                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                String hashtext = no.toString(16);

                // Add preceding 0s to make it 32 bit
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            }
            catch(NoSuchAlgorithmException e) {
                throw new RuntimeException("Hash value not accepted");
            }
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte

    }

   @Override
    public CoralPayCConnectAuthenticationResponse authenticate(CoralPayCConnectAuthenticationReqest authenticationReqest) {

        //String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiI5YmU2MTNkMi0wMmZkLTQ2ZDYtOTc0Yi02NzhlMGU4Mjc4ZDciLCJNZXJjaGFudElkIjoiMTA1N0tSQjEwMDAwMDAxIiwiVXNlcm5hbWUiOiJrYXJyYWJvIiwiUGFzc3dvcmQiOiIyMjEzMDkzODIxQDAxMCMzIiwiZXhwIjoxNzQ2ODY2NTExLCJpc3MiOiJodHRwczovL2NvcmFscGF5LmNvbSIsImF1ZCI6Imh0dHBzOi8vY29yYWxwYXkuY29tIn0.2jAKSHsq8BwCm71duf5S36G8Cy8VCuODETdygxW_HkE";

        return this.restClient.post()
               .uri("http://102.216.128.75:9090/bank9ja/api/v2/k1/authenticate")
               //.header("Authorization", token)
               .contentType(MediaType.APPLICATION_JSON)
               .body(authenticationReqest)
               .retrieve()
               .body(CoralPayCConnectAuthenticationResponse.class);

    }


}
