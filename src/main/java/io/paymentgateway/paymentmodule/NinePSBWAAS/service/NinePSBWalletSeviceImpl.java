package io.paymentgateway.paymentmodule.NinePSBWAAS.service;

import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request.*;
import io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.response.*;
import io.paymentgateway.paymentmodule.exceptions.PaymentServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static io.paymentgateway.paymentmodule.NinePSBWAAS.utils.Constant.PHOTO_DIRECTORY;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
public class NinePSBWalletSeviceImpl implements NinePSBWalletService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private WebClient webClient;

    @Override
    public NinePSBAuthenticateResponse authenticate(NinePSBAuthenticateRequest authRequest) {
        return this.restClient.post()
                .uri("http://102.216.128.75:9090/bank9ja/api/v2/k1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
//                .header(HttpHeaders.AUTHORIZATION,cred)
                .body(authRequest)
                .retrieve()
                .body(NinePSBAuthenticateResponse.class);
    }

    @Override
    public NinePSBOpenWalletResponse openWallet(NinePSBOpenWalletRequest openWalletRequest) {
        String cred = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTcxMTgyMTIsImlhdCI6MTcxNzExMTAxMiwianRpIjoiNjZhMzQ5NTktNjVmMi00OWI2LTgwNzItN2Y5MGYwNGE1NjZkIiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjVmNzczZjhmLTk5MDUtNDgxMi05OWZlLTJlYjI4NzQ2YWFjYSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI1Zjc3M2Y4Zi05OTA1LTQ4MTItOTlmZS0yZWIyODc0NmFhY2EiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.fLUP-HCDCy67HouP3CtrmGvdzromCqx9-dknJZLf0bDy-vTANUfNyFp0XAElTdWOeGgZyoopuD-1WK-2YF15S1nvLYpjxgH8gW5lRBDenAgo5EY_Va9XQUvK0eBxwHhs7w8Of40027IO_MfBbi-J0c0hkwWFa6ZNJd5xKAvpY5T90l4uoGYyH4m3PE2S4q4RmD5DUMc5aaBoFNhYwfzBbqTwYyDAbOID03uc-o9DD7Grvq9FLGn_zVX35a9LIpXeqpZdsZUMJovKfgDxGG_CmPHLicv7iPw3uMn6mYcu8uwE_NINUuBTKfGA3SVOuoOHTUjKIaRiXVXJRIqZgHBbcg";

                return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/open_wallet")
                .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,"Bearer "+cred)
                        .body(openWalletRequest)
                .retrieve()
                .body(NinePSBOpenWalletResponse.class);

    }

    @Override
    public NinePSBWalletEnquiryResponse walletEnquiry(NinePSBWalletEnquiryRequest enquiryRequest)  {

        return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/wallet_enquiry")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTY4OTUzNTcsImlhdCI6MTcxNjg4ODE1NywianRpIjoiMGQyMWFlMjQtZWNhNC00OTUxLTkxNzQtYjZhZmMzMDhiZDM0IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjI3ZWJhMGM5LTFkYzEtNDU4MS1iNjFjLTk1NWYwNzVmM2UwNyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiIyN2ViYTBjOS0xZGMxLTQ1ODEtYjYxYy05NTVmMDc1ZjNlMDciLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.nzp_hHpuTErjXnb5vctOi-3VzGQPrf5EU73FuQHcH1Ol_2iBtHdM-IUb8zn4Q3MYLT3wcwa7EB1XpHUBjbk0IlqFL91Tfw_-rlvYdWra6mnfCIM-h4Z3CWYh9SkJ_dRdjzOOfZwajzR0-Wxpfli24lNID-wM1kjHwwenlqPubhUMDl2vPzfdOVzlpOThpZtvcBq327xPHFUcUTpP3FL9RaOCEmPP6ORAQj1rp6bWOXapCOIuelCI3uP1CL6FYuJKACln-azBdrzLEddB31emRSshrSAK6veo7Tr1ItY5w9dfjeXbUQALeligJIaakcN31P1dNeWEuPA_fXJ3fxGgpg")
                .body(enquiryRequest)
                .retrieve()
                .body(NinePSBWalletEnquiryResponse.class);
    }

    @Override
    public NinePSBSingleWalletResponse debit_transfer(NinePSBSingleWalletRequest singledebitRequest) {

String cred = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTcxNDAwODQsImlhdCI6MTcxNzEzMjg4NCwianRpIjoiZmY2MGVmYjItNmU5MS00YTU5LTg3NGQtYzdlMDM3ZjQyMDlmIiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjZmZjM4ODg2LWNmNmUtNDdjNC05YzdhLTljNzQ5NjYwMmFkMyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI2ZmYzODg4Ni1jZjZlLTQ3YzQtOWM3YS05Yzc0OTY2MDJhZDMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.d7oJWU-QJwv8Jj2zvcKNchnTnw6LGXLPOapXDyxXBLOUpa2Sd6qvuketMp0cuLiTqTVvlccTJckoJFr8LpT_vf5KpM0X5Y2WMbTmC-ReoBo8Ky7kNLoGIxrzJrQ9XQCBW8oz-L21a33Jhxce2zKORSq6DqUUzBTW6ILRgQyhtp3nwmtmaK1bv8GW_g_gmamBjxtOxAszhcTVEU7zNa81sdxZzpXHgdVTT7FvIuQdeOq9C6tD1ATsRwM3I1M3ksgGCLk6SpFP1QmwsuONGNL3JIXXDMFJ6gpwc_A_LiohKHIpwGY16-2YQlYJ6Y6mlXDagbbnhUTFRl_so9m0qidjlA";
        return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/debit/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ cred)
                .body(singledebitRequest)
                .retrieve()
                .body(NinePSBSingleWalletResponse.class);

    }

    @Override
    public NinePSBSingleWalletResponse credit_transfer(NinePSBSingleWalletRequest singlecreditRequest)  {
        String cred = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTcxNDAwODQsImlhdCI6MTcxNzEzMjg4NCwianRpIjoiZmY2MGVmYjItNmU5MS00YTU5LTg3NGQtYzdlMDM3ZjQyMDlmIiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjZmZjM4ODg2LWNmNmUtNDdjNC05YzdhLTljNzQ5NjYwMmFkMyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI2ZmYzODg4Ni1jZjZlLTQ3YzQtOWM3YS05Yzc0OTY2MDJhZDMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.d7oJWU-QJwv8Jj2zvcKNchnTnw6LGXLPOapXDyxXBLOUpa2Sd6qvuketMp0cuLiTqTVvlccTJckoJFr8LpT_vf5KpM0X5Y2WMbTmC-ReoBo8Ky7kNLoGIxrzJrQ9XQCBW8oz-L21a33Jhxce2zKORSq6DqUUzBTW6ILRgQyhtp3nwmtmaK1bv8GW_g_gmamBjxtOxAszhcTVEU7zNa81sdxZzpXHgdVTT7FvIuQdeOq9C6tD1ATsRwM3I1M3ksgGCLk6SpFP1QmwsuONGNL3JIXXDMFJ6gpwc_A_LiohKHIpwGY16-2YQlYJ6Y6mlXDagbbnhUTFRl_so9m0qidjlA";

        return this.restClient.post()
                .uri("http://102.216.128.75:9090/waas/api/v1/credit/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ cred)
                .body(singlecreditRequest)
                .retrieve()
                .body(NinePSBSingleWalletResponse.class);
    }

    @Override
    public NinePSBUpgradeStatusResponse upgrade_status(NinePSBUpgradeStatusRequest upgradeRequest)  {
        String cred = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTcxNDg3NjEsImlhdCI6MTcxNzE0MTU2MSwianRpIjoiNzkwNmQzZTYtMDNjYy00NTFiLTg4OWEtNjExOWExM2UyMGE5IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjQ1ZDk5MzkyLTYzZjItNDUwZS04NGExLTkyYTNjYWI5ZThmMyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI0NWQ5OTM5Mi02M2YyLTQ1MGUtODRhMS05MmEzY2FiOWU4ZjMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.cOMaqNEFjhTjTSs9BG_cbps6S6jmTismd4jArj4LFFchaS5NhDy0AYzedASuPGjkSXpfrEx4d-CU9skm_t8HS0ZITCbC2sOu5JgWN63tj1dSdehkmgp15sk9-e2xeWjr1RXF2RNauJzfwjoEm7NHK8cAL5_KCIagqVwd4nCf8GHOd6YWvQpYRgVhzIpPgNZFzGRw3fPpPUCCReJrGLcO8YRFO-y7aUGUwCKTpBUYOrrPkfwRTzlqX7U29r_pULLN0IoxTE9ZUw40hk3VSc3cvN1NQdbTKFavTqJ3KM1XE9ZQ2FwfROjRN8gpTj1Ohc6qF1UiU5XusKeaWSGufAntgQ";
        return this.restClient
                .post()
                .uri("http://102.216.128.75:9090/waas/api/v1/upgrade_status")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ cred)
                .body(upgradeRequest)
                .retrieve()
                .body(NinePSBUpgradeStatusResponse.class);
    }

    @Override
    public NinePSBWalletUpgradeResponse wallet_upgrade(NinePSBWalletUpgradeRequest upgradeRequest) {

        String cred = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0ek1WWmtzOG1zcG01TmNHazNFdW1BVjZWYTFRQTVpTlYwcHVfU3hZQldBIn0.eyJleHAiOjE3MTcxNDg3NjEsImlhdCI6MTcxNzE0MTU2MSwianRpIjoiNzkwNmQzZTYtMDNjYy00NTFiLTg4OWEtNjExOWExM2UyMGE5IiwiaXNzIjoiaHR0cDovLzEwLjE4NS4yMjMuMjM6ODA4MC9yZWFsbXMvOXBzYiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiOGMyYjczMy1lMzIwLTQyM2EtOGVhNi02ZDBkNTBmNmRlYzEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ3YWFzIiwic2Vzc2lvbl9zdGF0ZSI6IjQ1ZDk5MzkyLTYzZjItNDUwZS04NGExLTkyYTNjYWI5ZThmMyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsibm90aWZpY2F0aW9uX3JlcXVlcnkiLCJkZWZhdWx0LXJvbGVzLTlwc2IiLCJ3YWxsZXRfdXBncmFkZV9maWxlX3VwbG9hZCIsImNyZWRpdF93YWxsZXQiLCJ3YWxsZXRfcmVxdWVyeSIsIndhbGxldF9zdGF0dXMiLCJkZWJpdF93YWxsZXQiLCJlZGl0X3dhYXNfYWNjIiwid2FsbGV0X3RyYW5zYWN0aW9ucyIsIndhbGxldF9lbnF1aXJ5Iiwib3RoZXJfYmFua3NfZW5xdWlyeSIsImdldF9iYW5rcyIsInVwZ3JhZGVfc3RhdHVzIiwiZ2V0X2FjY291bnRfbnVtYmVyIiwiZ2V0X3JlcXVlc3Rfc3RhdHVzIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuX3dhbGxldCIsIndhbGxldF91cGdyYWRlIiwib3Blbl9jb3Jwb3JhdGVfYWNjb3VudCIsInVtYV9hdXRob3JpemF0aW9uIiwiZ2V0X3dhbGxldCIsIm9wZW5fY29ycG9yYXRlX2FjY291bnRfZmlsZV91cGxvYWQiLCJjaGFuZ2Vfd2FsbGV0X3N0YXR1cyIsIndhbGxldF9vdGhlcl9iYW5rcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI0NWQ5OTM5Mi02M2YyLTQ1MGUtODRhMS05MmEzY2FiOWU4ZjMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImthcnJhYm8ifQ.cOMaqNEFjhTjTSs9BG_cbps6S6jmTismd4jArj4LFFchaS5NhDy0AYzedASuPGjkSXpfrEx4d-CU9skm_t8HS0ZITCbC2sOu5JgWN63tj1dSdehkmgp15sk9-e2xeWjr1RXF2RNauJzfwjoEm7NHK8cAL5_KCIagqVwd4nCf8GHOd6YWvQpYRgVhzIpPgNZFzGRw3fPpPUCCReJrGLcO8YRFO-y7aUGUwCKTpBUYOrrPkfwRTzlqX7U29r_pULLN0IoxTE9ZUw40hk3VSc3cvN1NQdbTKFavTqJ3KM1XE9ZQ2FwfROjRN8gpTj1Ohc6qF1UiU5XusKeaWSGufAntgQ";

                return this.restClient
                .post()
                .uri("http://102.216.128.75:9090/waas/api/v1/wallet_upgrade")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ cred)
                .body(upgradeRequest)
                .retrieve()
                .body(NinePSBWalletUpgradeResponse.class);

    }

    private final Function<String,String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
            .map(name -> "." + name.substring(filename.lastIndexOf(".")+ 1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) -> {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if (!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(id + fileExtension.apply(image.getOriginalFilename())), REPLACE_EXISTING);
            return ServletUriComponentsBuilder.fromCurrentContextPath().path("/contacts/image/" + filename).toUriString();
        }catch(Exception e) {
            throw new RuntimeException("Unable to save image");
        }
    };


}
