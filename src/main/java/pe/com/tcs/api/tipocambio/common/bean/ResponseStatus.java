package pe.com.tcs.api.tipocambio.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseStatus {
    private String status;
    private String codigoRespuesta;
    private String descripcionRespuesta;
    private String ubicacionError;
    private Date fecha;
    private String origen;
    private DetalleErrorType detalleError;
}
