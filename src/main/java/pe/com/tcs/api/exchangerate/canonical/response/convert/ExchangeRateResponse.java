package pe.com.tcs.api.exchangerate.canonical.response.convert;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExchangeRateResponse {
    private ResponseStatus responseStatus;
    private String developer;
    private Double amount;
    private Double exchangeRateAmount;
    private String sourceCoin;
    private String destinationCoin;
    private Double exchangeRate;
}
