package pe.com.tcs.api.exchangerate.canonical.request.convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateRequest {
    @NotBlank(message = "Amount must not be empty, must not have white spaces and must not be null")
    private Double amount;
    @NotBlank(message = "sourceCoin must not be empty, must not have white spaces and must not be null")
    private String sourceCoin;
    @NotBlank(message = "destinationCoin must not be empty, must not have white spaces and must not be null")
    private String destinationCoin;
}

