package io.paymentgateway.paymentmodule.NinePSBWAAS.DTO.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class WalletTransactionHistoryRequest {

    private String accountNumber;
    private String fromDate;
    private String toDate;
    private String numberOfItems;

}
