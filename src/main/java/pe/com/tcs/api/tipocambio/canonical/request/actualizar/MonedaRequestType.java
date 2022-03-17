package pe.com.tcs.api.tipocambio.canonical.request.actualizar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonedaRequestType {
    @NotBlank(message = "El tipo no deber ser vacío, no debe tener espacios en blanco y no debe ser nulo")
    private String tipo;
    @NotBlank(message = "El valor no deber ser vacío, no debe tener espacios en blanco y no debe ser nulo")
    private Double valor;
}
