package io.paymentgateway.paymentmodule;

import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVASAuthenticateRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.request.NinePSBVasApiAirtimeTopUpRequest;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVASAuthenticateResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.DTO.response.NinePSBVasApiAirtimeTopUpResponse;
import io.paymentgateway.paymentmodule.NinePsbVasApi.services.NinePSBVasApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class NinePSBVasApiTest {

    WebTestClient testClient = WebTestClient
            .bindToServer()
            .baseUrl("")
            .build();
    @Autowired
    private NinePSBVasApiService vasApiService;
//    @Autowired
//    private WebTestClient webClient;
   // NinePSBVASAuthenticateRequest authenticateRequest;

//    @Autowired
//    private NinePSBVASAuthenticateRequest authenticateRequest;

    @BeforeEach
    void setUp() {
//        authenticateRequest.setPassword("Rtn45bB9NYWM13lrVXp1C0f2TntTqxhLVrkCGvK9");
//        authenticateRequest.setUsername("KARRABO_TEST_qhhU2CotkR6YQipIq8zt");
    }

    @Test
    public void checkToAuthenticateNinePSBVasApi() {

        NinePSBVASAuthenticateRequest authenticateRequest = new NinePSBVASAuthenticateRequest("KARRABO_TEST_qhhU2CotkR6YQipIq8zt","Rtn45bB9NYWM13lrVXp1C0f2TntTqxhLVrkCGvK9");

        authenticateRequest.setPassword("Rtn45bB9NYWM13lrVXp1C0f2TntTqxhLVrkCGvK9");
        authenticateRequest.setUsername("KARRABO_TEST_qhhU2CotkR6YQipIq8zt");
//        testClient  //====> facing null exception
//                .post().uri("http://10.185.223.23:9090/identity/api/v1/authenticate")
//                //.header("Content-Type", "application/json")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(authenticateRequest)
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                // then
//                .expectStatus().isEqualTo(HttpStatus.OK);

       NinePSBVASAuthenticateResponse authenticateResponse = vasApiService.authenticate(authenticateRequest);
//
//        assertNotNull(resp.toString());
//        assertThat(resp.getStatus()).isEqualTo("success");
        //NinePSBVASAuthenticateResponse authenticateResponse = new NinePSBVASAuthenticateResponse();

                testClient.post().uri("http://10.185.223.23:9090/identity/api/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(authenticateRequest), NinePSBVASAuthenticateRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath(authenticateResponse.getResponseCode()).isNotEmpty()
                .jsonPath(authenticateResponse.getData().getAccessToken()).isEqualTo("sss");

    }

    @Test
    public void checkGetNetworkIsNotNull() {

        testClient.get().uri("http://102.216.128.75:9090/vas/api/v1//topup/network?phone=08136863271")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + "eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTY4MTA5MiwianRpIjoiMDJiOTkyZjctMjJlOC00ZmJjLTg0MTQtNzg3NzgzNzQ5ZGQ2IiwiZXhwIjoxNzE1Njg4MjkyfQ.IPCnyWgAjd2ewo7kyf-7-YdlAbLynRyLFs_R7Eu1H00ZsxR9JDGymZZPSj_TDem-mDZwobYMBQAvHerWvbKSAA")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response -> assertThat(response.getResponseBody()).isNotNull());

    }

    @Test
    public void checkGetDataPlansIsNotNull() {

        testClient.get().uri("http://102.216.128.75:9090/vas/api/v1//topup/dataPlans?phone=08136863271")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + "eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTY5MDk1OCwianRpIjoiYzJkNmJkZDgtYTI4NC00NjJhLTliNTMtM2YzZmZjMWQ5ZmQ4IiwiZXhwIjoxNzE1Njk4MTU4fQ.09LYwWCgwiRiqT4BQEg9SPQbQ0lLLzkfae3GI7pcbd6HzlF3PVHhiiL7zu1mz2nogDH340Zg0F1UQvT_aPP-mg")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response -> assertThat(response.getResponseBody()).isNotNull());

    }

    @Test
    public void checkGetTopUpStatus() {

        testClient.get().uri("http://102.216.128.75:9090/vas/api/v1/topup/status?transReference=VAS29PSBA000000100")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + "eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTY5OTY1MiwianRpIjoiZTU3ZDYyMTItMTEzNy00MjNhLTgxZjctMjM0MTM1MTVmNGE0IiwiZXhwIjoxNzE1NzA2ODUyfQ.jDubVOneGzfELa_EtTJKmjaky-sYhDA8NIi4jrZJ0FACNrxDziNRCOM4XEJdrIB-SnzRmjgUvWDJsrg0_ITT7w")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response -> assertThat(response.getResponseBody()).isNotNull());

    }



    @Test
    public void checkAirTimeTopUpIsNotNull() {
//        testClient.post().uri("http://102.216.128.75:9090/vas/api/v1/topup/airtime")
//                .header(HttpHeaders.AUTHORIZATION, "Bearer " + "eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTY4MTA5MiwianRpIjoiMDJiOTkyZjctMjJlOC00ZmJjLTg0MTQtNzg3NzgzNzQ5ZGQ2IiwiZXhwIjoxNzE1Njg4MjkyfQ.IPCnyWgAjd2ewo7kyf-7-YdlAbLynRyLFs_R7Eu1H00ZsxR9JDGymZZPSj_TDem-mDZwobYMBQAvHerWvbKSAA")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .consumeWith(response -> assertThat(response.getResponseBody()).isNotNull());
        NinePSBVasApiAirtimeTopUpRequest airtimeRequest = new NinePSBVasApiAirtimeTopUpRequest();

        airtimeRequest.setAmount("100");
        airtimeRequest.setNetwork("MTN");
        airtimeRequest.setPhoneNumber("08134943416");
        airtimeRequest.setDebitAccount("1100000299");
        airtimeRequest.setTransactionReference("VAS29PSBA000000043");

        NinePSBVasApiAirtimeTopUpResponse airtimeResponse = vasApiService.topUp(airtimeRequest);
        assertNotNull(airtimeResponse);
        assertThat(airtimeResponse.getMessage()).isEqualTo("Invalid account number");

//        String value ="eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTY5MDk1OCwianRpIjoiYzJkNmJkZDgtYTI4NC00NjJhLTliNTMtM2YzZmZjMWQ5ZmQ4IiwiZXhwIjoxNzE1Njk4MTU4fQ.09LYwWCgwiRiqT4BQEg9SPQbQ0lLLzkfae3GI7pcbd6HzlF3PVHhiiL7zu1mz2nogDH340Zg0F1UQvT_aPP-mg";
//
//        testClient.post().uri("http://102.216.128.75:9090/vas/api/v1/topup/airtime")
//                .header(HttpHeaders.AUTHORIZATION, "Bearer " + value)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(Mono.just(airtimeRequest), NinePSBVASAuthenticateRequest.class)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBody()
//                .jsonPath(airtimeResponse.getStatus()).isNotEmpty()
//                .jsonPath(airtimeResponse.getResponseCode()).isEqualTo("sss");
    }


    @Test
    public void checkDataTopUp() {

        testClient.post().uri("http://102.216.128.75:9090/vas/api/v1/topup/data")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + "eyJ0eXAiOiJKV1QiLCJrZXlJZCI6InZhc19qd3QiLCJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6WyJCSUxMU19QQVlNRU5UIiwiVE9QX1VQIl0sInN1YiI6IktBUlJBQk8iLCJpc3MiOiI5cHNiLmNvbS5uZyIsImlhdCI6MTcxNTcwMDQ2OCwianRpIjoiNjJiN2FlNzEtNjIzMC00NDQ0LTgyNDQtNTk1MTA1MjEyODhjIiwiZXhwIjoxNzE1NzA3NjY4fQ.NnBnEO673aXjFJwgnqpct41vl8mjohS_galOsU20NimB19hZ09Wl1TZSjEgFr3uaPRAJr6X9Oe9PNAfqtAc_BQ")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response -> assertThat(response.getResponseBody()).isNotNull());

    }

    @Test
    public void check(){}
}
