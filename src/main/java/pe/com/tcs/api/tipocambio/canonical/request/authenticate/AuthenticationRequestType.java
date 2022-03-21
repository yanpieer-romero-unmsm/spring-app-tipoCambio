package pe.com.tcs.api.tipocambio.canonical.request.authenticate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequestType implements Serializable {
    private String username;
    private String password;
}
