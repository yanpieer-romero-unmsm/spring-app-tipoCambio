package pe.com.tcs.api.tipocambio.integration.repository.monedas.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonedaDto {
    private String tipo;
    private Double valor;
}
