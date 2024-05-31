package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class WalletTransactionHistoryRequest {

    private String accountNumber;
    private String fromDate;
    private String toDate;
    private String numberOfItems;

}
