package pe.com.tcs.api.tipocambio.canonical.response.convertir;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tcs.api.tipocambio.common.bean.ResponseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TipoCambioResponseType {
    private ResponseStatus responseStatus;
    private String desarrollador;
    private Double monto;
    private Double montoConTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
}
