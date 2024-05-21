package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.request.CoralPayCConnectAuthenticationReqest;
import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.DTO.response.CoralPayCConnectAuthenticationResponse;
import io.paymentgateway.paymentmodule.CorallPayUSSDConnect.service.interfaces.CoralPayUSSDService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Instant;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CoralPayUSSDServiceTest {

    WebTestClient testClient = WebTestClient
            .bindToServer()
            .baseUrl("")
            .build();

    private String merchantId;
    private String terminalId;
    private String timeStamp;

    private String key;

    @Autowired
    private CoralPayUSSDService ussdService;
    @Test
    void name() {
    }

    @BeforeEach
    void setUp() {

        merchantId = "1057KRB10000001";
        terminalId = "1057KRB1";
        timeStamp = String.valueOf(Instant.now().getEpochSecond());
        key = "c5927068-a056-4358-bcdb-e669d622d059";

    }

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void checkToGenerateSignature() {

        String signature = ussdService.generateSignature(merchantId,terminalId,timeStamp,"2391c6ed-038a-43fa-b4c3-03b4a65e8abf");
        String t = "ds";
        log.info(timeStamp);
        //assertThat(timeStamp).isEqualTo("hg");
        assertThat(signature).isEqualTo(t);

    }

    @Test
    void checkAuthenticateIsNotNull() {

        //String credentials = username + ":" + password;
        // String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        CoralPayCConnectAuthenticationReqest request = new CoralPayCConnectAuthenticationReqest();

        request.setUsername("karrabo");
        request.setPassword("2213093821@010#3");

        CoralPayCConnectAuthenticationResponse response1 = ussdService.authenticate(request);

//        testClient.post().uri("https://testdev.coralpay.com/cgateproxy/api/v2/authentication")
//                .header(HttpHeaders.AUTHORIZATION, "Basic "+request.getPassword())
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .consumeWith(response -> assertThat(response.getResponseBody()).isNotNull());
        log.info(response1.toString());
        assertThat(response1.getToken()).isEqualTo("wee");

    }

}
