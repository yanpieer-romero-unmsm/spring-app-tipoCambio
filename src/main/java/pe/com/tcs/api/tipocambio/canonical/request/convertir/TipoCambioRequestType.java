package pe.com.tcs.api.tipocambio.canonical.request.convertir;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoCambioRequestType {
    @NotBlank(message = "El monto no deber ser vacío, no debe tener espacios en blanco y no debe ser nulo")
    private Double monto;
    @NotBlank(message = "La monedaOrigen no deber ser vacío, no debe tener espacios en blanco y no debe ser nulo")
    private String monedaOrigen;
    @NotBlank(message = "la monedaDestino no deber ser vacío, no debe tener espacios en blanco y no debe ser nulo")
    private String monedaDestino;
}
