package pe.com.tcs.api.exchangerate.integration.repository.coin.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDto {
    private String type;
    private Double value;
}
