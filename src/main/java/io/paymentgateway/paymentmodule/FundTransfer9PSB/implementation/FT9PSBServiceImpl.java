package io.paymentgateway.paymentmodule.FundTransfer9PSB.implementation;

import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FT9PSBAuthenticateRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FTAccountEnquiryRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FTBalanceEnquiryRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.request.FundTransferRequest;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FT9PSBAuthenticateResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FTAccountEnquiryResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FTBalanceEnquiryResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.DTO.response.FundTransferResponse;
import io.paymentgateway.paymentmodule.FundTransfer9PSB.service.FT9PSBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Slf4j
@RequiredArgsConstructor
@Service
public class FT9PSBServiceImpl implements FT9PSBService {

    private final RestClient restClient;

    @Override
    public FT9PSBAuthenticateResponse authenticate(FT9PSBAuthenticateRequest request) {

        return this.restClient
                .post()
                .uri("https://baastest.9psb.com.ng/ipaymw-api/v1/merchant/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                //.header(HttpHeaders.AUTHORIZATION, "Basic "+)
                .body(request)
                .retrieve()
                .body(FT9PSBAuthenticateResponse.class);

    }

    @Override
    public FTAccountEnquiryResponse enquiry(FTAccountEnquiryRequest request) {

        String cred = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJsZU9PTEp2bHowRitsSjZ2Q1c2bzhMV1NQZWUrTzRQQTZOSXFFL2FvOEUvanhlQ3Z2c3o1WmtGMFE2UVlUTWRrYkJSOXU0aHpBMWJJSWpHK3FPM09Eb09QWnFFekk3WVpVZ3BvejJrRmEyNUhaUkorQWdobVM5WHhMWkY5bzRqSDBnVGpGTWFNMDFlV0NOTUYyVUdLbXFJZU01RWp4QkphL3ZGU01EMXBLUjQ9IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvaGFzaCI6IjYyYWFjY2Q4ZTEzNjEzY2M1NDc4N2RmNzE1NmM5ODgwOGJkYmZmMjI3OTM0MGFiN2E5MjYyYjI4YmI4NGI5YmYxNDM3YTJhNmE1NDYzZmIxOTBiNTQwYjAxZDg1OWM3YmNkMjYzZTE4Yjk2NWEyYmMxMDEyNGRiODk2NWVjZWFhIiwicm9sZSI6ImxHT3JnbEhkNm1CelJ0NFZYMzc5dldZMjFCaC9YM2Y0K0phRllvbVhDeWRjK2cxMFZVMHhnMXhaaElWaWtJU3lBUGRaZGo4Wmo0eUhYbHBUenJzREV6UGtvZWJPczhGYmdqNEs4Z2xtSjlMcUZSM01NWnU4eVJEaHJ4THVlL3A5bWFGbldodlplZmVtdS83aWUyb0pxTStBeVFON2c4Z0srcFdaV1RoUldFb0QrRFdqS3hmYk1vdUFQenJ1NStPWkliQ1RvN1lQTjAzbjVqdStLM1d5NUdOcWNTUTZXVFR1cXAwaUk2RmdxOVJFVlN2OWtwMllpTmI4NGJLTlFBOFNLQU9SN1V6KzAra3lmWStoakU2bW9sR3d2OVRjeVA4cFJEYnMvQi81Y3BEajFkem9mTTJlWTJYcGNDWHB2ZU1qcWlNNkRsMzZKSjF6U0FFaGhWSDNzZz09IiwibmJmIjoxNzE2MjAzODg0LCJleHAiOjE3MTYyMTEwODQsImlhdCI6MTcxNjIwMzg4NCwiaXNzIjoiOVBTQl9TZXJ2aWNlX0ludGVybmFsIiwiYXVkIjoiOVBTQl9TZXJ2aWNlX0ludGVybmFsIn0.zB4cfJRibnIdEPohm9XWn-INywiAK87dU0yVjSwv7Ut0hNh3Lw4cEBymGQqYq0_fj64ztXxaSBWXkd9lL08NeQ";

        return this.restClient
                .post()
                .uri("https://baastest.9psb.com.ng/ipaymw-api/v1/merchant/account/enquiry")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, cred)
                .body(request)
                .retrieve()
                .body(FTAccountEnquiryResponse.class);

    }

    @Override
    public FundTransferResponse transfer(FundTransferRequest request) {

        String credential = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJWbS9WMHJuckFZNUZFVXM0dWJ0OWVqaUZMRGovNHRBai93RXFBZWEwS3hTdUJkcU0wM01GdnI4b0N2RWN5ZFBIUTFXTTROR0ROU21YYkdHbGhGd3pEeXhoU0xudCtndy9udVBjQ2tZT0IwOVFWMXoxdGJJbi80bzRTaVFjWEplLzF3YXN2MkpkTzVpRklNTDhvMXBUNVpYcGpjandYajhrUDU3eE9ieUhodkE9IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvaGFzaCI6IjYyYWFjY2Q4ZTEzNjEzY2M1NDc4N2RmNzE1NmM5ODgwOGJkYmZmMjI3OTM0MGFiN2E5MjYyYjI4YmI4NGI5YmYxNDM3YTJhNmE1NDYzZmIxOTBiNTQwYjAxZDg1OWM3YmNkMjYzZTE4Yjk2NWEyYmMxMDEyNGRiODk2NWVjZWFhIiwicm9sZSI6IlYzYjc1TENFdWFrZlIyNW04czkyeFhxNUMvdGIzbzRaN2F3SFNxMTJyTG5Gd0dnanlSME5ESTNYeTdzU1FMTXNZb3NJK3lMYU56UXlhZmEzNUExNjNjOHV2L1pPTzJnckdPTFBYNmsraEFOZlVmYk5Zd1lUYit1c2NxaFZZQUhaWlNIdDF1V0hoSTIyWGl6TUJMUzJKMENxc3ZzOUJRR0ZwVEFXUVhTNXduZVJaZXBRb3pldGtTT2JHeUwvYm8xb0ppQmVXdXhHVW41bzludjExWkxsSXd1TFRKRC9YWlk5RXh0WVg3bE1pdnkybVREWVhZb0NuU3ZIbnN6WTZEancyMTFHNXVIa3BhTjRuUEtKM0VnY25CcmhIdkFaUGtRelFZUVRYcElBc1dneXVGS3hwMWVnc2t2SU5HTEE5VkxDK2N3R09IdUdST3RoNEM1czdtVTA5Zz09IiwibmJmIjoxNzE2MjEyMDg3LCJleHAiOjE3MTYyMTkyODcsImlhdCI6MTcxNjIxMjA4NywiaXNzIjoiOVBTQl9TZXJ2aWNlX0ludGVybmFsIiwiYXVkIjoiOVBTQl9TZXJ2aWNlX0ludGVybmFsIn0.yDsU78NJZPt1ZzWQyQTJ1V4GcyJs7HsmFSNgVTwZQrNoycjEArrtTK9R9YHuK7Ss0bTi2QdlPtOPsTWwxC_eoQ";

        return this.restClient
                .post()
                .uri("https://baastest.9psb.com.ng/ipaymw-api/v1/merchant/account/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, credential)
                .body(request)
                .retrieve()
                .body(FundTransferResponse.class);

    }

    public String hashValue(String privateKey, String senderaccountnumber,String accountnumber, String bank, double amount, String reference) {

       // String password1 = privateKey +""+ senderaccountnumber +""+ bank +""+ amount +""+ reference;
        StringBuilder builder = new StringBuilder();

        builder.append(privateKey);
        builder.append(senderaccountnumber);
        builder.append(bank);
        builder.append(amount);
        builder.append(reference);

        String password1 = builder.toString();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(password1.getBytes());

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

    }

    @Override
    public FTBalanceEnquiryResponse balance(FTBalanceEnquiryRequest request) {

        String credential = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJqRFdNaWhiazgxaG0rRVQweTh6UDdDMkUzYjV4Mzh1ZlQ5cGRhQnZqVHJzZW1VRjA2WVF0VlZqekF1WWZsdS94czNUREhKWm1OZWxzQWlGajJOb2tOeWRxWFZEdXRKa092U1NmdDFySE9VWDJDalY3dzUxQ3NoWkloWThmR1FYR0hSTTY0djVZaHpyM1BRYWtyaDk1ZGJ5UGVyeWV6d2tnR2I4ZnE5SHI5STg9IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvaGFzaCI6IjYyYWFjY2Q4ZTEzNjEzY2M1NDc4N2RmNzE1NmM5ODgwOGJkYmZmMjI3OTM0MGFiN2E5MjYyYjI4YmI4NGI5YmYxNDM3YTJhNmE1NDYzZmIxOTBiNTQwYjAxZDg1OWM3YmNkMjYzZTE4Yjk2NWEyYmMxMDEyNGRiODk2NWVjZWFhIiwicm9sZSI6IldrMHE2RHJpL1V3ZXBlYTZmSFE2RE1oZVNnV3pOQXJHbnoxdksyOTEwakR4cjRCZ3dVZk5mamVFMlE1djJ6V2tlSmQ0eXNESE1nOFBaRHBQSUZsUnl4bnFwMnQ4SFJ0MTBjNXU0blA4NzhJdmJKMGNPRVQxZWVzUTRsS3huSEorU0RHZ1lOM0JGVzJsS2xuY0xnelcyV01Kdk5JZ0VsM2w1bkRXRUVoUVhqRlEvelRNM3lZdkhDNWVIRmxkeVNsZHVGbzVaL3k2TkF5bGdBV0VHT0h2Wm9DaFh2RnBtWnRyVkdsVHZWUHpYcjNnRjR3WElQdDQ5YzVDV0E1Syt1VFNOVXRMSkZhRzZ1UmNRbzdTelc2ZDd3SlRwMGdMN1JaU1hvWnlUNUUzWXVrL01RNGRuSFRzOUpob3AyUWIyM1RPRFhxdjdnaEFRYmM5Z0NDMWpleDBlZz09IiwibmJmIjoxNzE2NDM5MzY3LCJleHAiOjE3MTY0NDY1NjcsImlhdCI6MTcxNjQzOTM2NywiaXNzIjoiOVBTQl9TZXJ2aWNlX0ludGVybmFsIiwiYXVkIjoiOVBTQl9TZXJ2aWNlX0ludGVybmFsIn0.eqFdl_AbxjKsj2OPhFUOiibKQ3-8MnJxryASsw8aIaZOqqlcHlPWLK3WKS30QPr1n5NW-LKDWeOyMv_2GGw2Ww";
        return this.restClient
                .post()
                .uri("https://baastest.9psb.com.ng/ipaymw-api/v1/merchant/account/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, credential)
                .body(request)
                .retrieve()
                .body(FTBalanceEnquiryResponse.class);

    }


}
