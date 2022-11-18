package pe.com.tcs.api.exchangerate.canonical.response.authenticate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationResponse implements Serializable {
    private ResponseStatus responseStatus;
    private String developer;
    private String jwt;

    public AuthenticationResponse(String jwt) {
    }
}
