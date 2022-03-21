package pe.com.tcs.api.tipocambio.canonical.response.authenticate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.com.tcs.api.tipocambio.common.bean.ResponseStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationResponseType implements Serializable {
    private ResponseStatus responseStatus;
    private String desarrollador;
    private String jwt;

    public AuthenticationResponseType(String jwt) {
    }
}
