package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.services.NinePSBVasApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class NinePSBVasApiTest {

//    WebTestClient testClient = WebTestClient
//            .bindToServer()
//            .baseUrl("")
//            .build();
    @Autowired
    private NinePSBVasApiService vasApiService;
//    @Autowired
//    private WebTestClient webClient;
   // NinePSBVASAuthenticateRequest authenticateRequest;

//    @Autowired
//    private NinePSBVASAuthenticateRequest authenticateRequest;

//    @Autowired
//    private NinePSBVASAuthenticateResponse authenticateResponse;

    @BeforeEach
    void setUp() {
//        authenticateRequest.setPassword("Rtn45bB9NYWM13lrVXp1C0f2TntTqxhLVrkCGvK9");
//        authenticateRequest.setUsername("KARRABO_TEST_qhhU2CotkR6YQipIq8zt");
    }

    @Test
    public void checkToAuthenticateNinePSBVasApi() {

//        testClient.post().uri("http://10.185.223.23:9090/identity/api/v1/authenticate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(Mono.just(authenticateRequest), NinePSBVASAuthenticateRequest.class)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBody()
//                .jsonPath(authenticateResponse.getResponseCode()).isNotEmpty()
//                .jsonPath(authenticateResponse.getData().getAccessToken()).isEqualTo("sss");

        NinePSBVASAuthenticateRequest authenticateRequest = new NinePSBVASAuthenticateRequest("KARRABO_TEST_qhhU2CotkR6YQipIq8zt","Rtn45bB9NYWM13lrVXp1C0f2TntTqxhLVrkCGvK9");

//        this.authenticateRequest.setPassword("Rtn45bB9NYWM13lrVXp1C0f2TntTqxhLVrkCGvK9");
//        this.authenticateRequest.setUsername("KARRABO_TEST_qhhU2CotkR6YQipIq8zt");
//        testClient  //====> facing null exception
//                .post().uri("http://10.185.223.23:9090/identity/api/v1/authenticate")
//                //.header("Content-Type", "application/json")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(authenticateRequest)
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                // then
//                .expectStatus().isEqualTo(HttpStatus.OK);

        NinePSBVASAuthenticateResponse resp = vasApiService.authenticate(authenticateRequest);

        assertNotNull(resp.toString());
        assertThat(resp.getStatus()).isEqualTo("success");

    }

}
