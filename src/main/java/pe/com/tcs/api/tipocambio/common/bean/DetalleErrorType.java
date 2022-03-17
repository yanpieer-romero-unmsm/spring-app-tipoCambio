package pe.com.tcs.api.tipocambio.common.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleErrorType {
    private String errorCode;
    private String errorDescripcion;
}
