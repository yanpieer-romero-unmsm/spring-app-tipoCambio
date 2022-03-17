package pe.com.tcs.api.tipocambio.canonical.response.actualizar;

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
public class MonedaResponseType {
    private ResponseStatus responseStatus;
    private String desarrollador;
    private String mensaje;
    private String tipo;
    private Double valor;
}
