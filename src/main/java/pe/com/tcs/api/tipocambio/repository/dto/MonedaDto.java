package pe.com.tcs.api.tipocambio.repository.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonedaDto {
    private String tipo;
    private Double valor;
}
